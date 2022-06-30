import org.apache.commons.csv.CSVParser;
import utils.csv;

import java.sql.Array;
import java.util.*;

public class CsvTask {
    public static void main(String[] args) {
        csv obj = new csv();
        String file1 = "C:\\Users\\tumkiran\\csv-file\\csv-file\\src\\main\\resources\\datafiles\\readInput.csv";
        String file2 = "C:\\Users\\tumkiran\\csv-file\\csv-file\\src\\main\\resources\\datafiles\\readInput2.csv";
        CSVParser csvParser1 = obj.loadFile(file1);
        CSVParser csvParser2 = obj.loadFile(file2);
        List<String> header1 = obj.getHeaders(csvParser1);
        List<String> header2 = obj.getHeaders(csvParser2);
        Map<String, Integer> final_header = new HashMap<>();
        for (int i=0; i<header1.size(); i++){
            final_header.put(header1.get(i), 1);
        }
        for (int i=0; i<header2.size(); i++){
            final_header.put(header2.get(i), 2);
        }
     /*  for (String key: final_header.keySet()
            ) {
          System.out.println(key);
        }*/
        Map<String, Integer[]> final_data = new HashMap<>();
        for (int i=0; i<header1.size(); i++){
            if (final_header.containsKey(header1.get(i))){
                Integer[] firstFileIndex = new Integer[2];
                firstFileIndex[0] = i;
                firstFileIndex[1] = -1;
                final_data.put(header1.get(i), firstFileIndex);
            }
            System.out.println();
        }
        for (int i=0; i<header2.size(); i++){
            if (final_header.containsKey(header2.get(i))) {
                Integer[] firstFileIndex = new Integer[2];
                firstFileIndex[0] = -1;
                firstFileIndex[1] = i;
                if (final_data.containsKey(header2.get(i))){
                    Integer[] secondFileIndex = final_data.get(header2.get(i));
                    secondFileIndex[1] = i;
                }
                else {
                    final_data.put(header2.get(i), firstFileIndex);
                }
            }
        }
        String file3Content = "";
        for (String key: final_data.keySet()
             ) {
            file3Content += key+",";
        }
        file3Content+="\n";
        List<List<String>> row1 = obj.getRows(csvParser1);
        List<List<String>> row2 = obj.getRows(csvParser2);
        for (int i=0; i<row1.size(); i++){
            List rowFile1 = row1.get(i);
            List rowFile2 = row2.get(i);
           for (String key: final_data.keySet()
             ) {
               // file3Content += rowFile1.get(final_data.get(key)[0]+rowFile2.get(final_data.get(key)[1]);
                file3Content += getData(rowFile1,final_data.get(key)[0])+getData(rowFile2,final_data.get(key)[1])+",";
        }
           file3Content+="\n";
        }

//        for (String key: final_data.keySet()
//             ) {
//            System.out.println("key "+key+" "+final_data.get(key)[0]+" "+final_data.get(key)[1]);
//        }
//        key Country 0 0
//        key Population 2 -1
//        key Rankings -1 2
//        key Capital 1 1

       obj.fileWriter("file3.csv", file3Content);
    }
    static String getData(List<String> ls, int index) {
        if(index==-1) return "";
        return ls.get(index);
    }
}
