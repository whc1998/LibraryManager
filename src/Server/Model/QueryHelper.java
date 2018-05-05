package Server.Model;


import Server.Control.MessageContorl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QueryHelper {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Scanner scanner;

    public QueryHelper() {
        try {
            connection = DBHelper.getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String add(String booknaem,String author,String price ) {
        MessageContorl messageContorl=new MessageContorl();
        String checksql = "select * from Book where bookName='" + booknaem + "'";
        try {
            resultSet = statement.executeQuery(checksql);
            if (resultSet.next()){
                System.out.println("该书以及存在");
                return messageContorl.reBackMessage("该书以及存在");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into Book values ( '" + booknaem + "','" + author + "','" + price + "')";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageContorl.reBackMessage("添加成功");
    }

    public String delete(String bookName) {
        MessageContorl messageContorl=new MessageContorl();
        String sql = "delete from Book where bookName='" + bookName + "'";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageContorl.reBackMessage("删除成功");
    }

    public String update(String oldbook,String newbook,String author,String price) {
        MessageContorl messageContorl=new MessageContorl();
        String sql = "update Book set bookName='" + newbook + "'," + "author='" + author + "'," + "price='" + price +
                "' where bookName='" + oldbook + "'";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageContorl.reBackMessage("修改成功");
    }

    public String qurey(String bookName) {
        MessageContorl messageContorl=new MessageContorl();
        String sql = "select * from Book where bookName='" + bookName + "'";
        try {
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String rebackmessage=resultSet.getString("bookName") + "\t"
                        + resultSet.getString("author") + "\t" + resultSet.getDouble("price");
               return messageContorl.reBackMessage(rebackmessage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "该书不存在";
    }

    public String qureyAll() {
        String sql = "select * from Book";
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        int number=0;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                number++;
                JSONObject jsonObject1=new JSONObject();
                jsonObject1.put("bookName",resultSet.getString("bookName"));
                jsonObject1.put("author",resultSet.getString("author"));
                jsonObject1.put("price",resultSet.getDouble("price"));
                jsonArray.add(jsonObject1);
            }
            jsonObject.put("number",number);
            jsonObject.element("data",jsonArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public void connectionstop() {
        try {
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
