package citygenerator.model.DataLayer.BussinesLogic.voronoi;

import de.alsclo.voronoi.Voronoi;
import de.alsclo.voronoi.graph.Point;

import java.util.Collection;

public class VoronoiDiagram {

    private Collection<Point> points;

    protected VoronoiDiagram() { }

    public VoronoiDiagram(Collection<Point> points) {
        this.points = points;
    }

    public Voronoi create() {
        Voronoi voronoi = new Voronoi(points);
        return voronoi;
    }
}
