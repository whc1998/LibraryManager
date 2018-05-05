package Server;

import Server.Control.MessageContorl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class NetThread extends Thread {

    private Socket socket;

    public NetThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            Scanner client=new Scanner(inputStream);
            outputStream = socket.getOutputStream();
            while (true){
                MessageContorl messageContorl=new MessageContorl();
                String receiveStr=client.nextLine();
                System.out.println(receiveStr);
                String backMessage = messageContorl.WorkOutMessage(receiveStr);
                System.out.println(backMessage);
                String retext=backMessage+"\n";
                outputStream.write(retext.getBytes());
                if (receiveStr.equals("0")){
                    break;
                }
            }
            System.out.println("客户端退出");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
