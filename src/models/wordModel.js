import mongoose, {
  Schema,
} from 'mongoose';

/**
 * Create database scheme for notes
 */
const NoteScheme = new Schema({
  word: {
    type: String,
    required: 'What is the word?',
  },
  type: {
    type: String,
    required: 'What is the type of the word?',
  },
});

export default mongoose.model('Words', NoteScheme);
