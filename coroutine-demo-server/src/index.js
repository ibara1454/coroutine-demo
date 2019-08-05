const http = require('http');

// Returns type `text/plain` with request path
http.createServer((req, res) => {
  console.log(req.url);
  const delay = Math.random() * 10000; // wait 0ms ~ 10000ms

  setTimeout(() => {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end(req.url);
  }, delay);
}).listen(80, () => console.log('Server http://localhost:80'));
