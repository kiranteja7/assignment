package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.*;
import java.util.*;

public class csv {

    public CSVParser loadFile(String filepath) {
        CSVParser csvParser = null;
        try {
            Reader reader = new FileReader(filepath);
            csvParser = CSVFormat.DEFAULT.builder().setHeader().build().parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return csvParser;
    }

    //------------------------Getters-------------------------

    public List<String> getHeaders(CSVParser csvParser) {
        List<String> headers = new ArrayList<String>();
        try {
            headers = csvParser.getHeaderNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return headers;
    }

    public String getHeaderAtIndex(CSVParser csvParser, int index) {

        return getHeaders(csvParser).get(index);
    }

    public List<List<String>> getRows(CSVParser csvParser) {
        List<List<String>> rows = new ArrayList<List<String>>();
        try {
            Iterator<CSVRecord> iterator = csvParser.iterator();
           // int rowCount = 1;
            try {
                while (iterator.hasNext()) {
                    rows.add(iterator.next().toList());
                  //  rowCount++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

//    --validation--

    public void fileWriter(String fileName, String content) {
        String path = "C:\\Users\\tumkiran\\csv-file\\csv-file\\src\\main\\resources\\datafiles";
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }
        path = "C:\\Users\\tumkiran\\csv-file\\csv-file\\src\\main\\resources\\datafiles" + fileName;
        File fileObject = new File(path);
        try {
            if (fileObject.exists()) {
                fileObject.delete();
            }
            if (!fileObject.exists()) {
                fileObject.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileObject, true));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}