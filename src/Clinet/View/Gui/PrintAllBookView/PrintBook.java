/*
 * Created by JFormDesigner on Tue Apr 24 13:59:32 CST 2018
 */

package Clinet.View.Gui.PrintAllBookView;


import Clinet.Control.Control;
import Clinet.Model.Client;
import Clinet.View.MainView;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * @author whc
 */
public class PrintBook extends JFrame {

    private Client client;
    private Control control;

    public PrintBook(Client client) {
        this.client=client;
        control=new Control();
        initComponents();
    }

    private void initComponents() {

        setTitle("打印图书");
        vector=new Vector<>();
        JSONObject jsonObject = control.printBook();
        String clientserver = client.clientserver(jsonObject.toString());
        JSONObject jsonObject1=JSONObject.fromObject(clientserver);
        int number= (int) jsonObject1.get("number");
//        int i=Integer.parseInt(number);
        JSONArray jsonArray=jsonObject1.getJSONArray("data");
        for (int j=0;j<number;j++){
            JSONObject jsonObject11=jsonArray.getJSONObject(j);
            String bookname= (String) jsonObject11.get("bookName");
            String author= (String) jsonObject11.get("author");
            int price= (int) jsonObject11.get("price");
            vector.add(bookname+"                          "
                    +author+"                          "
                    +price);
        }

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList(vector);
        button1 = new JButton();

        list1.setBorder(BorderFactory.createTitledBorder("书名                            作者                              价格"));

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u67e5\u8be2\u7ed3\u679c");
        contentPane.add(label1);
        label1.setBounds(205, 45, 55, 25);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(100, 75, 295, 250);

        //---- button1 ----
        button1.setText("\u9000\u51fa");
        contentPane.add(button1);
//        button1.setBounds(new Rectangle(new Point(225, 340), button1.getPreferredSize()));
        button1.setBounds(225,340,70,33);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrintBook.this.setVisible(false);
                MainView mainView=new MainView();
                mainView.setVisible(true);

            }
        });

        contentPane.setPreferredSize(new Dimension(460, 390));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;

    private Vector<String> vector=null;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
