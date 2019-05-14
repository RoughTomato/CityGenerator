import mongoose, {
  Schema,
} from 'mongoose';

/**
 * Create database scheme for stats
 */
const StatisticScheme = new Schema({
  name: {
    type: String,
    required: 'What is the name?',
  },
  max: {
    type: Number,
    required: 'Set maximum for statistic',
  },
  min: {
    type: Number,
    required: 'Set minimum for statistic',
    default: 0,
  },
});

export default mongoose.model('Stat', StatisticScheme);
