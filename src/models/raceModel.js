import mongoose, {
  Schema,
} from 'mongoose';

/**
 * Create database scheme for races
 */
const RaceScheme = new Schema({
  name: {
    type: String,
    required: 'What is the name?',
  },
  perks: {
    statistics: {
      name: { type: String },
      value: { type: Number },
      default: null,
    },
    abilities: {
      name: { type: String },
      level: { type: Number },
    },
    default: null,
  },
});

export default mongoose.model('Race', RaceScheme);
