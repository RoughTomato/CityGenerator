import mongoose, {
  Schema,
} from 'mongoose';

/**
 * Create database scheme for words
 */
const WordScheme = new Schema({
  word: {
    type: String,
    required: 'What is the word?',
  },
  type: {
    type: String,
    required: 'What is the type of the word?',
  },
});

export default mongoose.model('Words', WordScheme);
