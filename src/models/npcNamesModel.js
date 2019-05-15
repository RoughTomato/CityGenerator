import mongoose, {
  Schema,
} from 'mongoose';

/**
 * Create database scheme for names
 */
const NameScheme = new Schema({
  name: {
    type: String,
    required: 'What is the name?',
  },
});

export default mongoose.model('Name', NameScheme);
