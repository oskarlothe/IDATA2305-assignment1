package computation;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import servers.SingleThreadedServer;
import utils.ResponseGenerator;

public class SearchSimulator {
  public void processClientRequest(Socket clientSocket) {
        long time1 = System.currentTimeMillis();
        System.out.println("Request processing started at: " + time1);
        try{Thread.sleep(10 * 1000);}
        catch (InterruptedException e){}
        long time2 = System.currentTimeMillis();
        System.out.println("Request processing ended at: " + time2);
        System.out.println(ResponseGenerator.generatorResponseHTML(time1, time2));
    }
}