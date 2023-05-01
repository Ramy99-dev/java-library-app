import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketServer {
    private static final Map<String, Socket> clients = new HashMap<>();
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            while(true)
            {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Accepted connection from client: " + clientSocket);
                    ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
                    String clientId = (String) input.readObject();
                    clients.put(clientId, clientSocket);
                    System.out.println("Client ID " + clientId + " registered");
                 
                       
                    new Thread(() -> {
                        while (true) {
                            try {
                                HashMap<String, String> message = (HashMap<String, String>) input.readObject();
                                System.out.println("Received message from " + clientId + ": " + message.get("content"));
        
                                String destClientId = message.get("destClientId");
                                Socket destSocket = clients.get(destClientId);
                                if (destSocket != null) {
                                    ObjectOutputStream destOutput = new ObjectOutputStream(destSocket.getOutputStream());
                                    destOutput.writeObject(message.get("client"));
                                    destOutput.flush();
                                } else {
                                    System.out.println("Destination client " + destClientId + " not found");
                                }
                            } catch (IOException | ClassNotFoundException e) {
                                clients.remove(clientId);
                                System.out.println("Client " + clientId + " disconnected");
                                break;
                            }
                        }
                    }).start();
                        
                   
        
                
                }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}