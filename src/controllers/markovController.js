import mongoose from 'mongoose';
import Foswig from 'foswig';
import Word from '../models/wordModel';

const MarkovChain = require('markov-chain-js/src/markov-chain');

exports.getWord = (req, res) => {
  const markov = new Foswig(2);
  const arr = [];
  Word.find({}, '-_id')
    .select('word')
    .exec((err, w) => {
      if (err) {
        res.json(err);
      }
      w.forEach((wrd) => {
        arr.push(wrd.word);
      });
      markov.addWordsToChain(arr);

      res.json(markov.generateWord(2, 10, true, 100));
    });
};

exports.add = (req, res) => {
  const newWord = new Word({ word: req.params.word, type: req.params.type });

  newWord.save((err) => {
    if (err) {
      res.send(err);
    }
    res.json({
      200: `word: ${req.params.word}, type: ${req.params.type} successfully created.`,
    });
  });
};

exports.delete = (req, res) => {
  Word.remove({
    _id: req.params.wordId,
  }, (err) => {
    if (err) {
      res.send(err);
    }
    res.json({
      message: `word ${req.params.wordId} successfully deleted.`,
    });
  });
};
