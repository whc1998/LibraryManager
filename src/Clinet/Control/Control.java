package Clinet.Control;

import net.sf.json.JSONObject;

public class Control {

    public JSONObject addBook(String bookName,String bookAuthor,String bookPrice){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("method",1);
        jsonObject.put("bookName",bookName);
        jsonObject.put("bookAuthor",bookAuthor);
        jsonObject.put("bookPrice",bookPrice);
        return jsonObject;
    }

    public JSONObject deleteBook(String bookName){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("method",2);
        jsonObject.put("bookName",bookName);
        return jsonObject;
    }

    public JSONObject updateBook(String oldBookName,String newBookName,String bookAuthor,String bookPrice){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("method",3);
        jsonObject.put("oldBookName",oldBookName);
        jsonObject.put("newBookName",newBookName);
        jsonObject.put("bookAuthor",bookAuthor);
        jsonObject.put("bookPrice",bookPrice);
        return jsonObject;
    }

    public JSONObject quaryBook(String bookName){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("method",4);
        jsonObject.put("bookName",bookName);
        return jsonObject;
    }

    public JSONObject printBook(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("method",5);
        return jsonObject;
    }

}
