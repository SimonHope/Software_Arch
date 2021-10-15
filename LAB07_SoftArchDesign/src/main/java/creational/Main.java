package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException{

        // Current usage
//        BookMetadataFormatter formatter = null;
//        try {
//            formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.CSV);
//            formatter.append(TestData.dragonBook);
//            formatter.append(TestData.dinosaurBook);
//            System.out.print(formatter.getMetadataString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }

        // Expected usage
        System.out.println("-----------JSON-----------");
        BookMetadataExporter exporterJSON = new JSONBookMetadataExporter();
        exporterJSON.add(TestData.sailboatBook);
        exporterJSON.add(TestData.GoFBook);
        exporterJSON.export(System.out);

        System.out.println("-----------XML-----------");
        BookMetadataExporter exporterXML = new XMLBookMetadataExporter();
        exporterXML.add(TestData.sailboatBook);
        exporterXML.add(TestData.GoFBook);
        exporterXML.export(System.out);

        System.out.println("-----------CSV-----------");
        BookMetadataExporter exporterCSV = new CSVBookMetadataExporter();
        exporterCSV.add(TestData.sailboatBook);
        exporterCSV.add(TestData.GoFBook);
        exporterCSV.export(System.out);
    }
}
