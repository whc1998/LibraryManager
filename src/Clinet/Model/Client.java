package Clinet.Model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;

    private static Client client;



    private Client() {
        try {
            socket = new Socket("127.0.0.1", 11004);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Client getInstance(){
        if (client==null){
            synchronized(Client.class){
                if (client==null){
                    client=new Client();
                }
            }
        }
        return client;
    }

    public String clientserver(String message){
        OutputStream outputStream = null;
        InputStream inputStream=null;
        String backMeesage = null;
        try {
            outputStream = socket.getOutputStream();
            outputStream.write((message+"\n").getBytes());
            inputStream = socket.getInputStream();
            Scanner servlet=new Scanner(inputStream);
            backMeesage=servlet.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return backMeesage;
    }

}
