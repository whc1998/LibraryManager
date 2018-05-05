/*
 * Created by JFormDesigner on Tue Apr 17 14:59:51 CST 2018
 */

package Clinet.View.Gui.DeleteBookView;

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
public class DeleteBook extends JFrame {

    private Client client;
    private Control control;

    public DeleteBook(Client client) {
        this.client=client;
        control=new Control();
        initComponents();
    }

    private void initComponents() {

        setTitle("删除图书");

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        bookName = new JTextField();
        accept = new JButton();
        refues = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4e66\u540d");
        contentPane.add(label1);
        label1.setBounds(105, 135, 40, 17);
        contentPane.add(bookName);
        bookName.setBounds(140, 130, 200, 25);

        //---- accept ----
        accept.setText("\u786e\u5b9a");
        contentPane.add(accept);
        accept.setBounds(125, 205, 65, 33);

        //---- refues ----
        refues.setText("\u53d6\u6d88");
        contentPane.add(refues);
        refues.setBounds(285, 205, 75, 33);

        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookname = bookName.getText();
                if (bookname.isEmpty()){
                    JOptionPane.showMessageDialog(null,"书名不能为空","提示",JOptionPane.ERROR_MESSAGE);
                }
                JSONObject jsonObject = control.deleteBook(bookname);
                String clientserver = client.clientserver(jsonObject.toString());
                JSONObject jsonObject1=JSONObject.fromObject(clientserver);
                String message = (String) jsonObject.get("message");
                JOptionPane.showMessageDialog(null,message,"提示",JOptionPane.ERROR_MESSAGE);
            }
        });

        refues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteBook.this.setVisible(false);
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
    private JButton accept;
    private JButton refues;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
