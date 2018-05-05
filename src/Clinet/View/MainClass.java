package Clinet.View;

import javax.swing.*;
import java.awt.*;

public class MainClass {

    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                MainView mainView=new MainView();
                mainView.setTitle("欢迎来到图书馆");
                mainView.setVisible(true);
            }
        });
    }

}
