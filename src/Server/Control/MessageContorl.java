package Server.Control;

import Server.Model.QueryHelper;
import net.sf.json.JSONObject;

public class MessageContorl {

    public String WorkOutMessage(String message) {
        JSONObject jsonObject = JSONObject.fromObject(message);
        int method = (int) jsonObject.get("method");
        QueryHelper queryHelper = new QueryHelper();
        switch (method) {
            case 1:
                String bookname = (String) jsonObject.get("bookName");
                String bookAuthor = (String) jsonObject.get("bookAuthor");
                String price = (String) jsonObject.get("bookPrice");
                return queryHelper.add(bookname, bookAuthor, price);
            case 2:
                String bookname2 = (String) jsonObject.get("bookName");
                return queryHelper.delete(bookname2);
            case 3:
                String oldBookname = (String) jsonObject.get("oldBookName");
                String newBookname = (String) jsonObject.get("newBookName");
                String newbookAuthor = (String) jsonObject.get("bookAuthor");
                String bookPrice = (String) jsonObject.get("bookPrice");
                return queryHelper.update(oldBookname, newBookname, newbookAuthor, bookPrice);
            case 4:
                String bookname4 = (String) jsonObject.get("bookName");
                return queryHelper.qurey(bookname4);
            case 5:
                return queryHelper.qureyAll();
        }
        return null;
    }

    public String reBackMessage(String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", message);
        return jsonObject.toString();
    }

}
