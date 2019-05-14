import mongoose, {
  Schema,
} from 'mongoose';

/**
 * Create database scheme for abilities
 */
const AbilitiesScheme = new Schema({
  name: {
    type: String,
    required: 'What is the name?',
  },
  description: {
    type: String,
    required: 'What is the description?',
  },
  bonus: {
    statBonuses: [{
      name: { type: String },
      value: { type: Number },
    }],
    description: { type: String },
    required: 'What is the bonus?',
  },
});

export default mongoose.model('Abilities', AbilitiesScheme);
