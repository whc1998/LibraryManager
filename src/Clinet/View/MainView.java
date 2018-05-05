/*
 * Created by JFormDesigner on Tue Apr 10 16:46:30 CST 2018
 */

package Clinet.View;

import Clinet.Model.Client;
import Clinet.View.Gui.AddBookView.AddBook;
import Clinet.View.Gui.DeleteBookView.DeleteBook;
import Clinet.View.Gui.PrintAllBookView.PrintBook;
import Clinet.View.Gui.QuarryBookView.QuarryBook;
import Clinet.View.Gui.UpdataBookView.UpdataBook;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author whc
 */
public class MainView extends JFrame {

    private Client client;

    public MainView() {
        client=Client.getInstance();
        initComponents();
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        addbook = new JButton();
        deletebook = new JButton();
        updatabook = new JButton();
        quarybook = new JButton();
        printbook = new JButton();
        quit = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- addbook ----
        addbook.setText("\u6dfb\u52a0\u56fe\u4e66");
        contentPane.add(addbook);
        addbook.setBounds(180, 35, 193, 33);
        addbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addBookview==null){
                    addBookview = new AddBook(client);
                }
                addBookview.setVisible(true);
                setMainView(false);
            }
        });

        //---- deletebook ----
        deletebook.setText("\u5220\u9664\u56fe\u4e66");
        contentPane.add(deletebook);
        deletebook.setBounds(180, 85, 193, 33);

        deletebook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deleteBookview==null){
                    deleteBookview = new DeleteBook(client);
                }
                deleteBookview.setVisible(true);
                setMainView(false);
            }
        });

        //---- updatabook ----
        updatabook.setText("\u4fee\u6539\u56fe\u4e66");
        contentPane.add(updatabook);
        updatabook.setBounds(180, 135, 193, 33);

        updatabook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (updataBookview==null){
                    updataBookview=new UpdataBook(client);
                }
                updataBookview.setVisible(true);
                setMainView(false);
            }
        });

        //---- quarybook ----
        quarybook.setText("\u67e5\u8be2\u56fe\u4e66");
        contentPane.add(quarybook);
        quarybook.setBounds(180, 185, 193, 33);

        quarybook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quarryBookview==null){
                    quarryBookview=new QuarryBook(client);
                }
                quarryBookview.setVisible(true);
                setMainView(false);
            }
        });

        //---- printbook ----
        printbook.setText("\u6253\u5370\u56fe\u4e66");
        contentPane.add(printbook);
        printbook.setBounds(180, 235, 193, 33);

        printbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (printBookview==null){
                    printBookview=new PrintBook(client);
                }
                printBookview.setVisible(true);
                setMainView(false);
            }
        });

        //---- quit ----
        quit.setText("\u9000\u51fa\u7cfb\u7edf");
        contentPane.add(quit);
        quit.setBounds(180, 285, 193, 33);

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "确认退出","提示" , JOptionPane.YES_NO_OPTION);
                if (i==0){
                    setMainView(false);
                    client.clientserver("0");
                }
            }
        });

        contentPane.setPreferredSize(new Dimension(550, 370));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void setMainView(boolean a) {
        this.setVisible(a);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton addbook;
    private JButton deletebook;
    private JButton updatabook;
    private JButton quarybook;
    private JButton printbook;
    private JButton quit;

//    private Connection connection = null;
//    private Statement statement = null;

    private AddBook addBookview;
    private DeleteBook deleteBookview;
    private UpdataBook updataBookview;
    private QuarryBook quarryBookview;
    private PrintBook printBookview;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
