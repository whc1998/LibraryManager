/*
 * Created by JFormDesigner on Mon Apr 16 11:00:37 CST 2018
 */

package Clinet.View.Gui.AddBookView;

import Clinet.Control.Control;
import Clinet.Model.Client;
import Clinet.View.MainView;
import net.sf.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author whc
 */
public class AddBook extends JFrame {

    private Client client;
    private Control control;

    public AddBook(Client client) {
        this.client=client;
        control=new Control();
        initComponents();
    }

    private void initComponents() {

        setTitle("添加图书");

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        bookName = new JTextField();
        label2 = new JLabel();
        authorName = new JTextField();
        label3 = new JLabel();
        bookpirce = new JTextField();
        agree = new JButton();
        refues = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4e66\u540d");
        contentPane.add(label1);
        label1.setBounds(130, 60, 35, 17);
        contentPane.add(bookName);
        bookName.setBounds(175, 55, 185, 25);

        //---- label2 ----
        label2.setText("\u4f5c\u8005");
        contentPane.add(label2);
        label2.setBounds(130, 105, 40, 17);
        contentPane.add(authorName);
        authorName.setBounds(175, 100, 185, 25);

        //---- label3 ----
        label3.setText("\u4ef7\u683c");
        contentPane.add(label3);
        label3.setBounds(130, 155, 45, 17);
        contentPane.add(bookpirce);
        bookpirce.setBounds(175, 150, 185, 25);

        //---- agree ----
        agree.setText("\u786e\u5b9a");
        contentPane.add(agree);
        agree.setBounds(145, 250, 70, 33);

        agree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String booknaem=bookName.getText();
                String author=authorName.getText();
                String price=bookpirce.getText();
                JSONObject jsonObject = control.addBook(booknaem, author, price);
                client.clientserver(jsonObject.toString());
                JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.ERROR_MESSAGE);
            }
        });



        //---- refues ----
        refues.setText("\u53d6\u6d88");
        contentPane.add(refues);
        refues.setBounds(295, 250, 70, 33);

        refues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBook.this.setVisible(false);
                MainView mainView=new MainView();
                mainView.setVisible(true);

            }
        });

        contentPane.setPreferredSize(new Dimension(460, 370));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField bookName;
    private JLabel label2;
    private JTextField authorName;
    private JLabel label3;
    private JTextField bookpirce;
    private JButton agree;
    private JButton refues;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
