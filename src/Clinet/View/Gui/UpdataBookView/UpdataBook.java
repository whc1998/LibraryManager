/*
 * Created by JFormDesigner on Tue Apr 17 16:29:57 CST 2018
 */

package Clinet.View.Gui.UpdataBookView;

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
public class UpdataBook extends JFrame {

    private Client client;
    private Control control;

    public UpdataBook(Client client) {
        this.client=client;
        control=new Control();
        initComponents();
    }

    private void initComponents() {

        setTitle("修改图书");

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        oldbookName = new JTextField();
        label2 = new JLabel();
        newBookName = new JTextField();
        label3 = new JLabel();
        bookauthor = new JTextField();
        label4 = new JLabel();
        bookprice = new JTextField();
        accept = new JButton();
        quit = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u65e7\u4e66\u540d");
        contentPane.add(label1);
        label1.setBounds(110, 60, 55, 17);
        contentPane.add(oldbookName);
        oldbookName.setBounds(160, 55, 225, oldbookName.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u65b0\u4e66\u540d");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(110, 90), label2.getPreferredSize()));
        contentPane.add(newBookName);
        newBookName.setBounds(160, 90, 225, 21);

        //---- label3 ----
        label3.setText("\u4f5c\u8005");
        contentPane.add(label3);
        label3.setBounds(115, 125, 36, 17);
        contentPane.add(bookauthor);
        bookauthor.setBounds(160, 125, 225, 21);

        //---- label4 ----
        label4.setText("\u4ef7\u683c");
        contentPane.add(label4);
        label4.setBounds(115, 160, 36, 17);
        contentPane.add(bookprice);
        bookprice.setBounds(160, 160, 225, 21);

        //---- accept ----
        accept.setText("\u786e\u5b9a");
        contentPane.add(accept);
//        accept.setBounds(new Rectangle(new Point(120, 240), accept.getPreferredSize()));
        accept.setBounds(120, 240, 70, 33);

        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String updatename = oldbookName.getText();
                String bookname = newBookName.getText();
                String author = bookauthor.getText();
                String price = bookprice.getText();
                JSONObject jsonObject1 = control.updateBook(updatename, bookname, author, price);
                String clientserver = client.clientserver(jsonObject1.toString());
                JSONObject rebackjsonObject=JSONObject.fromObject(clientserver);
                JOptionPane.showMessageDialog(null, rebackjsonObject.get("message").toString(), "提示", JOptionPane.ERROR_MESSAGE);
            }
        });

        //---- quit ----
        quit.setText("\u53d6\u6d88");
        contentPane.add(quit);
//        quit.setBounds(new Rectangle(new Point(320, 240), quit.getPreferredSize()));
        quit.setBounds(320, 240, 70, 33);

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdataBook.this.setVisible(false);
                MainView mainView = new MainView();
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
    private JTextField oldbookName;
    private JLabel label2;
    private JTextField newBookName;
    private JLabel label3;
    private JTextField bookauthor;
    private JLabel label4;
    private JTextField bookprice;
    private JButton accept;
    private JButton quit;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
