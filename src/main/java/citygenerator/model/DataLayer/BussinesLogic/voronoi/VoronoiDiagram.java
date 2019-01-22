package citygenerator.model.DataLayer.BussinesLogic.voronoi;

import de.alsclo.voronoi.Voronoi;
import de.alsclo.voronoi.graph.Edge;
import de.alsclo.voronoi.graph.Point;

import java.util.Collection;
import java.util.stream.Stream;

public class VoronoiDiagram {

    private Collection<Point> points;
    private Voronoi diagram;

    protected VoronoiDiagram() { }

    public VoronoiDiagram(Collection<Point> points) {
        this.points = points;
        diagram = new Voronoi(points);
    }

    public Stream<Edge> generateEdgeStream() {
        return diagram.getGraph().edgeStream();
    }
}
