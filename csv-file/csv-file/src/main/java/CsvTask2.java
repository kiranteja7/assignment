import org.apache.commons.csv.CSVParser;
import utils.csv;

import java.util.List;

public class CsvTask2 {
    public static void main(String[] args) {
        csv obj = new csv();
        String file1 = "C:\\Users\\tumkiran\\csv-file\\csv-file\\src\\main\\resources\\datafiles\\readInput.csv";
        CSVParser csvParser = obj.loadFile(file1);
        List<List<String>> rows = obj.getRows(csvParser);

        for(int i=0;i< rows.size();i++){
            List row = rows.get(i);
              for(int j=0;j<row.size();j++){
                  Object key= row.get(i);

              }
        }
    }
}
