import mongoose from 'mongoose';
import word from '../models/wordModel.js';



exports.getWord() = (req, res) => {
  const MarkovChain = require('markov-chain-js');

  const options = {
    source: word.find({}).select('word'),
    order: 3,
  };

  let generator = new MarkovChain(options);
  res.json(generator.generate());
};

exports.addWord() = (req, res) => {
    const newWord = new word(req.body);

    newWord.save((err, newword) => {
        if (err) {
            res.send(err);
        }

        res.json(newword);
    })
};

exports.delete() = (req, res) => {
  word.remove({
      _id: req.params.wordId
  }, (err) => {
      if (err) {
          res.send(err);
      }

      res.json({
        message: `word ${req.params.wordId} successfully deleted.`
      });
  })
};