package citygenerator.model.DataLayer.BussinesLogic.voronoi;

import de.alsclo.voronoi.graph.Edge;
import de.alsclo.voronoi.graph.Point;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PolygonGeneratorTest {

    private VoronoiDiagram vd;
    private PolygonGenerator pg;
    private final int size = 512;
    Stream<Point> gen;

    @Before
    public void setUp() {
        Random r = new Random(9235563856L);
        gen = Stream.generate(() -> new de.alsclo.voronoi.graph.Point
                (r.nextDouble() * size,r.nextDouble() * size));
        vd = new VoronoiDiagram(gen.limit(1024).collect(Collectors.toList()));
        pg = new PolygonGenerator(vd.generateEdgeStream());
    }

//    @Test
//    public void generatedPolygon() {
//        Polygons poly = new Polygons();
//        poly.addAll(pg.generatePolygons());
//        ArrayList<Point> points = new ArrayList<>();
//        for(Object o : poly) {
//            Polygon p = (Polygon) o;
//            for(Object obj : p) {
//                Edge edge = (Edge) obj;
//                if(edge.getA() != null && edge.getB() != null) {
//                    Point a = edge.getA().getLocation();
//                    Point b = edge.getB().getLocation();
//                    points.add(a);
//                    points.add(b);
//                }
//            }
//        }
//
//    }

    @Test
    public void generatePolygonsNotEmptyTest() {
        assertThat(pg.generatePolygons().isEmpty(), Matchers.is(false));
    }
}