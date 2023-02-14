package servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerError;

import javax.sound.sampled.SourceDataLine;

import computation.SearchSimulator;

public class SingleThreadedServer implements Runnable {

    protected int serverPort = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;

    public SingleThreadedServer(int port) {
        this.serverPort = port;
    }

    public void run() {
        try {
            while (!isStopped()) {
                // wait for a connection
                // on receiving a request, execute the heavy computation
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                SearchSimulator simulator = new SearchSimulator();
                simulator.processClientRequest(clientSocket);
                clientSocket.close();
                isStopped = true;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Server Stopped.");
    
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        // implementation to stop the server from the main thread if needed
    }

    public void openServerSocket() throws IOException {
        serverSocket = new ServerSocket(serverPort);
    }
}