import servers.MultiThreadedServer;
import servers.SingleThreadedServer;

class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting server");
        // Start your server here
        MultiThreadedServer server = new MultiThreadedServer(8080);
        server.openServerSocket();
        server.run();
    }
}