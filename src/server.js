import app from './app';

const port = process.env.PORT || '8081'; app.listen(port);

console.log(`If you're running docker image use http://172.17.0.2:${port} instead of 127.0.0.1:${port}`);
console.log(`Listening on port ${port}`);
