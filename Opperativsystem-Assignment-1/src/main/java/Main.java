import servers.MultiThreadedServer;
import servers.SingleThreadedServer;

/**
 * Main function where you can choose to run either the SingleThreadedServer or the MultiThreadedServer
 * 
 * @author Christian Rø
 * @author Oscar Lothe
 */

public class Main {

    private static int serverPort = 8080;


    /**
     * here you can comment out what you want to run
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //MultiThreadedServer multiThreadedServer = new MultiThreadedServer(serverPort);
        //multiThreadedServer.run();

        //SingleThreadedServer singleThreadedServer = new SingleThreadedServer(serverPort);
        //singleThreadedServer.run();
    }
}
