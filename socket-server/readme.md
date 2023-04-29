# Socket Server :
<center><img width="500px" src="assets/sequence diagram .png"/></center>
</br>
This code implements a Java socket server that accepts incoming connections from multiple clients and forwards messages between them. The server listens on port 5000 for incoming client connections, and maintains a mapping of client IDs to their respective sockets using a HashMap.

When a new client connects to the server, the accept() method of ServerSocket returns a Socket object that represents the client. The code then creates an ObjectInputStream to read data from the client, and reads the client ID from the input stream using the readObject() method. The client ID and socket are then stored in the clients map.

Next, a new thread is created to handle incoming messages from this client. Within this thread, the code continuously listens for incoming messages from the client using the readObject() method. When a message is received, it is parsed as a HashMap<String, String> and the destination client ID is retrieved from the message. The destination socket is then retrieved from the clients map using the destination client ID. If the destination socket is found, the message is forwarded to the destination client using an ObjectOutputStream. If the destination socket is not found, an error message is printed to the console.