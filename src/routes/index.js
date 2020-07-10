import markov from '../controllers/markovController';
import voronoi from '../controllers/voronoiController';
//import npc from '../controllers/npcController';
//import stat from '../controllers/statController';
//import abilities from '../controllers/abilitiesController';

export default (app) => {
  app.route('api/v1/markov')
    .get(markov.getWord);

  app.route('/api/v1/markov/:word/:type')
    .get(markov.add);

  app.route('/api/v1/markov/:wordId')
    .delete(markov.delete);

  app.route('/api/v1/voronoi')
    .get(voronoi.generate);

  // app.route('/api/v1/npc')
  //   .put(npc.add)
  //   .get(npc.generate)
  //   .post(npc.save);

  // app.route('/api/v1/race/')
  //   .put(race.addRace);

  // app.route('/api/v1/race/:name')
  //   .get(race.get)
  //   .delete(race.delete);

  // app.route('/api/v1/abilities/:name')
  //   .get(abilities.get)
  //   .delete(abilities.delete);

  // app.route('/api/v1/stat/')
  //   .put(stat.add);

  // app.route('/api/v1/stat/:name')
  //   .get(stat.get)
  //   .delete(stat.delete);

  // app.route('/api/v1/npc/:name')
  //   .get(npc.getByName)
  //   .delete(npc.delete);
};
