package creational;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject BookObj;
    private JSONArray BookList;

    public JSONBookMetadataFormatter(){
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        BookObj = new JSONObject();
        BookList = new JSONArray();
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        JSONObject NewBook = new JSONObject();
        JSONArray NewAuthors = new JSONArray();

        for(String author : b.getAuthors()){
            NewAuthors.add(author);
        }

        NewBook.put("ISBN", b.getISBN());
        NewBook.put("Authors", NewAuthors);
        NewBook.put("Title", b.getTitle());
        NewBook.put("Publisher", b.getPublisher());

        BookList.add(NewBook);
        BookObj.put("Books", BookList);
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return BookObj.toJSONString();
    }
}