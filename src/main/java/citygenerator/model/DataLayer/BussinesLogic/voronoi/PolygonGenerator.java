package citygenerator.model.DataLayer.BussinesLogic.voronoi;

import de.alsclo.voronoi.graph.Edge;
import de.alsclo.voronoi.graph.Point;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PolygonGenerator {

    Collection<Edge> edges;
    Stack<Point> sites;

    public PolygonGenerator(Stream<Edge> edges) {
        this.edges = edges.collect(Collectors.toList());
        sites = new Stack<>();
    }

    public PolygonGenerator(Collection<Edge> edges) {
        this.edges = edges;
        sites = new Stack<>();
    }

    /**
     * Loads all sites into Stack.
     */
    private void getSites() {
        this.edges.forEach(e ->
                this.sites.push(e.getSite1()));
    }

    /**
     * Generates list of polygons by finding all edges belonging to each site.
     * @return list of generated polygons.
     * */
    public Polygons generatePolygons() {
        Polygons polygons = new Polygons();
        getSites();
        while(!sites.isEmpty()) {
            Point site = sites.pop();
            ArrayList<Edge> matchedEdges = new ArrayList<>();
            for (Edge e : edges) {
                if (e.getSite1().equals(site)){
                    matchedEdges.add(e);
                }
            }
                polygons.add(new Polygon(site, matchedEdges));
        }
        return polygons;
    }
}
