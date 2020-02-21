package javaguide.bio;

import java.io.IOException;
import java.net.ServerSocket;

public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        new Thread(() -> {
            while (true) {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
