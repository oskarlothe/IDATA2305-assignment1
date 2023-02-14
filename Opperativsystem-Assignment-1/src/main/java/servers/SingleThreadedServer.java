package servers;

import computation.SearchSimulator;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Represents a Single Threaded Server.
 *
 * @author Christian Rø
 * @author Oscar Lothe
 */
public class SingleThreadedServer implements Runnable {

    protected int serverPort = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;

    public SingleThreadedServer(int port) {
        this.serverPort = port;
    }

    /**
     * Runs the single threaded server.
     */
    public void run() {
        System.out.println("Single-threaded server listening on port: " + serverPort);

        openServerSocket();
        Socket clientSocket;
        while (!isStopped()) {
            /* Listens for incoming requests from clients. */
            try {
                clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            } catch (Exception e) {
                stop();
                e.printStackTrace();
            }
        }
        System.out.println("Server Stopped.");
    }

    /**
     * Sets if the server is running or not.
     * @return if the server is stopped or not as a boolean, true if stopped, false if not.
     */
    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    /**
     * Stops the server.
     */
    public synchronized void stop()  {
        isStopped = true;
        try {
            serverSocket.close();
        }
        catch (Exception e) { e.printStackTrace();
        }
    }

    /**
     * Opens a server socket.
     */
    private void openServerSocket() {
        try {
            serverSocket = new ServerSocket(serverPort);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the address of the client and proceeds to request processing.
     */
    private void handleClient(Socket clientSocket) throws Exception {
        System.out.println(clientSocket.getInetAddress() + ":" + clientSocket.getPort());
        SearchSimulator.processClientRequest(clientSocket, "Singlethreaded Server: ");
    }
}