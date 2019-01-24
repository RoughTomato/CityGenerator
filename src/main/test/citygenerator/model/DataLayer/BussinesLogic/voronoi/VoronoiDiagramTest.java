package citygenerator.model.DataLayer.BussinesLogic.voronoi;

import de.alsclo.voronoi.graph.Edge;
import de.alsclo.voronoi.graph.Point;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.hamcrest.core.IsInstanceOf;
import static org.hamcrest.core.IsNull.notNullValue;

public class VoronoiDiagramTest {

    ArrayList<Point> points;
    VoronoiDiagram voronoi;

    private double[] xarray = { 1, 4, 8, 16, 12, 14, 40, 32, 77, 80, 25, 90};
    private double[] yarray = { 2, 5, 7, 23, 44, 24, 60, 77, 24, 78, 90, 20 };

    @Before
    public void setUp(){
        points = new ArrayList<>();
        for(int i = 0; i < xarray.length; i++) {
            points.add(new Point(xarray[i], yarray[i]));
        }
        voronoi = new VoronoiDiagram(points);
    }

    @Rule
    public ExpectedException expectedNull = ExpectedException.none();

    @Test
    public void generateEdgeStream() {
        Stream<Edge> actual = voronoi.generateEdgeStream();
        assertThat(actual, notNullValue());
    }

    @Test
    public void testEdgePair() {
        Point[] p = new Point[2];
        Point[] expected = new Point[2];
        expected[0] = new Point(92.1890756302521,50.23949579831934);
        expected[1] = new Point(59.8420523138833,-54.88832997987927);
        boolean status = false;
        voronoi.generateEdgeStream().filter(
                e -> e.getA() != null && e.getB() != null).forEach(e -> {
            p[0] = e.getA().getLocation();
            p[1] = e.getB().getLocation();
        });

        if(p[0].equals(expected[0]) &&
           p[1].equals(expected[1])) {
            status = true;
        }
        assertThat(status, is(true));
    }

    @Test
    public void relaxTest() {
        assertThat(voronoi.relax(), IsInstanceOf.instanceOf(VoronoiDiagram.class));
    }

    @Test
    public void generateWhenPointsAreNull() throws Exception{
        expectedNull.expect(NullPointerException.class);
        voronoi = new VoronoiDiagram(null);
    }

}