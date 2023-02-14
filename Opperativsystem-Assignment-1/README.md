# Opperativsystem-Assignment-1
How to run either of the the programs:
1. Open Main.java
2. Remove the comment lines on the server-type you want to run.
4. Run Main.main(args).
5. Send HTTP GET requests on localhost:port via Postman

We found that when an HTTP GET request is sent, there are actually two data exchanges from the client to the server. We think that the first message, which has no data, marks the beginning of the TCP three-way handshake. The second message contains the HTTP GET request.
The program is designed to always produce the same kind of answer from the server, regardless of what the client sends. This means that the server's response to the initial empty message will be the same as the response to the actual request.
When using the single-threaded server, the server must generate a message twice, which takes 10 seconds. Thus, productivity is decreased. When the server is multi-threaded, however, both client