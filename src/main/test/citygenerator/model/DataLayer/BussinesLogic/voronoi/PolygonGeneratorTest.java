package citygenerator.model.DataLayer.BussinesLogic.voronoi;

import de.alsclo.voronoi.graph.Point;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PolygonGeneratorTest {

    private VoronoiDiagram vd;
    private PolygonGenerator pg;
    private final int size = 512;

    @Before
    public void setUp() {
        Random r = new Random(9235563856L);
        Stream<Point> gen = Stream.generate(() -> new de.alsclo.voronoi.graph.Point
                (r.nextDouble() * size,r.nextDouble() * size));
        vd = new VoronoiDiagram(gen.limit(1024).collect(Collectors.toList()));
        pg = new PolygonGenerator(vd.generateEdgeStream());
    }

    @Test
    public void generatePolygonsNotEmpty() {
        assertThat(pg.generatePolygons().isEmpty(), Matchers.is(false));
    }
}