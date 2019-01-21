package citygenerator.model.DataLayer.BussinesLogic.voronoi;

import de.alsclo.voronoi.Voronoi;
import de.alsclo.voronoi.graph.Graph;
import de.alsclo.voronoi.graph.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

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

    @Test
    public void create() {
        Voronoi voronoi = veronoi.create();
        Graph graph = voronoi.getGraph();
        Set<Point> set = graph.getSitePoints();
        for(Point point : set) {
           // System.out.println(point.x + ":" + point.y);
        }
        voronoi.getGraph().edgeStream().filter(e -> e.getA() != null && e.getB() != null).forEach(e -> {
            Point a = e.getA().getLocation();
            Point b = e.getB().getLocation();
            System.out.println("Edge " + a + ":" + b);
        });
    }
}