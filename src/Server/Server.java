package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args){
        try {
            ServerSocket serverSocket=new ServerSocket(11004);
            while (true){
                System.out.println("服务器启动");
                Socket accept = serverSocket.accept();
                ExecutorService executorService= Executors.newFixedThreadPool(4);
                NetThread netThread=new NetThread(accept);
                executorService.execute(netThread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
