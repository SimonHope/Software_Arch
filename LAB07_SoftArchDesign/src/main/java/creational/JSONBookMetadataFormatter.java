package creational;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.IOException;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject BookObj;
    private JSONArray BookList;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        BookObj = new JSONObject();
        BookList = new JSONArray();
        BookObj.put(Book.class.getSimpleName()+"s", BookList);
        return null;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        JSONObject NewBook = new JSONObject();
        JSONArray NewAuthors = new JSONArray();
        for(String author : b.getAuthors()){
            NewAuthors.add(author);
        }

        NewBook.put(Book.Metadata.ISBN.value,b.getISBN());
        NewBook.put(Book.Metadata.AUTHORS.value, NewAuthors);
        NewBook.put(Book.Metadata.TITLE.value,b.getTitle());
        NewBook.put(Book.Metadata.PUBLISHER.value,b.getPublisher());
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return BookObj.toString();
    }
}
