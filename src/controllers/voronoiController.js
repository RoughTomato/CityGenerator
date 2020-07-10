import Voronoi from 'voronoi';

exports.generate = (req, res) => {
  const voronoi = new Voronoi();
  const bbox = {
    xl: 0, xr: 800, yt: 0, yb: 600,
  }; // xl is x-left, xr is x-right, yt is y-top, and yb is y-bottom
  const sites = [{ x: 200, y: 200 }, { x: 50, y: 250 }, { x: 400, y: 100 }];

  // a 'vertex' is an object exhibiting 'x' and 'y' properties. The
  // Voronoi object will add a unique 'voronoiId' property to all
  // sites. The 'voronoiId' can be used as a key to lookup the associated cell
  // in diagram.cells.

  const diagram = voronoi.compute(sites, bbox);

  console.log("Edges:");
  console.log(diagram.edges);

  diagram.cells.forEach((cell) => {
    console.log("cell:");
    console.log(cell);
    cell.halfedges.forEach((halfedge) => {
      console.log("halfedge:");
      console.log(halfedge);
    })
  });

  res.json({ code: 200 });
};
