/*
 * Created by JFormDesigner on Thu Apr 19 16:37:34 CST 2018
 */

package Clinet.View.Gui.QuarryBookView;



import Clinet.Control.Control;
import Clinet.Model.Client;
import Clinet.View.MainView;
import net.sf.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author whc
 */
public class QuarryBook extends JFrame {

    private Client client;
    private Control control;

    public QuarryBook(Client client) {
        this.client=client;
        control=new Control();
        initComponents();
    }

    private void initComponents() {

        setTitle("查询图书");

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        bookName = new JTextField();
        label1 = new JLabel();
        okbutton = new JButton();
        disagree = new JButton();
        label2 = new JLabel();
        reult = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(bookName);
        bookName.setBounds(155, 100, 230, 25);

        //---- label1 ----
        label1.setText("\u4e66\u540d");
        contentPane.add(label1);
        label1.setBounds(100, 105, 35, 17);

        //---- okbutton ----
        okbutton.setText("\u786e\u5b9a");
        contentPane.add(okbutton);
        okbutton.setBounds(110, 230, 70, 33);

        okbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookname=bookName.getText();
                JSONObject jsonObject = control.quaryBook(bookname);
                String clientserver = client.clientserver(jsonObject.toString());
                JSONObject rebackjsonObject=JSONObject.fromObject(clientserver);
                reult.setText((String) rebackjsonObject.get("message"));
            }
        });

        //---- disagree ----
        disagree.setText("\u53d6\u6d88");
        contentPane.add(disagree);
        disagree.setBounds(270, 230, 70, 33);

        disagree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuarryBook.this.setVisible(false);
                MainView mainView=new MainView();
                mainView.setVisible(true);
            }
        });

        //---- label2 ----
        label2.setText("\u67e5\u8be2\u7ed3\u679c");
        contentPane.add(label2);
        label2.setBounds(90, 160, label2.getPreferredSize().width, 20);
        contentPane.add(reult);
        reult.setBounds(155, 160, 230, 25);

        contentPane.setPreferredSize(new Dimension(460, 370));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField bookName;
    private JLabel label1;
    private JButton okbutton;
    private JButton disagree;
    private JLabel label2;
    private JTextField reult;

    private ResultSet resultSet ;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
