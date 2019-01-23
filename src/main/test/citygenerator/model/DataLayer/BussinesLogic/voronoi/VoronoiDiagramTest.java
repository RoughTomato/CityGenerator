package citygenerator.model.DataLayer.BussinesLogic.voronoi;

import de.alsclo.voronoi.Voronoi;
import de.alsclo.voronoi.graph.Edge;
import de.alsclo.voronoi.graph.Graph;
import de.alsclo.voronoi.graph.Point;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.array;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class VoronoiDiagramTest {

    ArrayList<Point> points;
    VoronoiDiagram veronoi;

    private double[] xarray = { 1, 4, 8, 16, 12, 14, 40, 32, 77, 80, 25, 90};
    private double[] yarray = { 2, 5, 7, 23, 44, 24, 60, 77, 24, 78, 90, 20 };

    @Before
    public void setUp(){
        points = new ArrayList<>();
        for(int i = 0; i < xarray.length; i++) {
            points.add(new Point(xarray[i], yarray[i]));
        }
        veronoi = new VoronoiDiagram(points);
    }

    @Rule
    public ExpectedException expectedNull = ExpectedException.none();

    @Test
    public void generateEdgeStream() {
        Stream<Edge> actual = veronoi.generateEdgeStream();
        assertThat(actual, notNullValue());
    }

    @Test
    public void testEdgePair() {
        Point[] p = new Point[2];
        Point[] expected = new Point[2];
        expected[0] = new Point(92.19, 50.24);
        expected[1] = new Point(59.84, -54.89);
        boolean status = false;
        veronoi.generateEdgeStream().filter(
                e -> e.getA() != null && e.getB() != null).forEach(e -> {
            p[0] = e.getA().getLocation();
            p[1] = e.getB().getLocation();
        });
        if(p[0].equals(expected[0]) && p[1].equals(expected[1])) {
            status = true;
        }
        assertThat(status, is(true));
    }


    @Test
    public void generateWhenPointsAreNull() throws Exception{
        expectedNull.expect(NullPointerException.class);
        veronoi = new VoronoiDiagram(null);
    }

}