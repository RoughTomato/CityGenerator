import express from 'express';
import mongoose from 'mongoose';
import bodyParser from 'body-parser';

import routes from './routes/index';

const app = express();

// change to 127.0.0.1 if running outside of docker.
// mongoose.connect('mongodb://host.docker.internal:21017/');

mongoose.connect('mongodb://127.0.0.1/cities').then(() => {
  console.log("connected to the database");
}).catch((err) => {
  console.log("Couldn't connect to the database: " + err);
});

/**
* Middleware
*/
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// catch 400
app.use((err, req, res, next) => {
  // console.log(err.stack);
  res.status(400).send(`Error: ${res.originUrl} not found`);
  next();
});

// catch 500
app.use((err, req, res, next) => {
  // console.log(err.stack);
  res.status(500).send(`Error: ${err}`);
  next();
});

/**
* Register the routes
*/
routes(app);

export default app;
