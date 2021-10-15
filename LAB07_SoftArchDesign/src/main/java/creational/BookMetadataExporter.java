package creational;

import java.io.PrintStream;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class BookMetadataExporter extends BookCollection {

    public String export() throws ParserConfigurationException, IOException {
        // Please implement this method. You may create additional methods as you see fit.
        BookMetadataFormatter formatter = createBookExport();
        for(Book BookObj : books){
            formatter.append(BookObj);
        }
        return formatter.getMetadataString();
    }
    public abstract BookMetadataFormatter createBookExport() throws ParserConfigurationException, IOException;
}
