import markov from '../controllers/markov';

export default (app) => {
  app.route('/markov')
    .get(markov.getWord)
    .post(markov.addWord);

  app.route('/markov/:wordId')
    .delete(markov.delete);
};
