import computation.SearchSimulator;
import servers.SingleThreadedServer;

class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting server");
        // Start your server here
        SingleThreadedServer server = new SingleThreadedServer(8080);
        server.openServerSocket();
        server.run();
    }
}