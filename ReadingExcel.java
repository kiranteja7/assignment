package com.kodnest.assignment;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingExcel {
    public static void main(String[] args) throws IOException {

        int String=0,num=0,bool=0;
        String excelFilePath=".\\datafiles\\readInput.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook= new XSSFWorkbook(inputStream);

       XSSFSheet sheet= workbook.getSheet("Sheet1");

       int rows= sheet.getLastRowNum();

        int cols=sheet.getRow(1).getLastCellNum();

        for(int r=0;r<=rows;r++)
        {
           XSSFRow row= sheet.getRow(r);
            for(int c=0;c<cols;c++){
               XSSFCell cell= row.getCell(c);

               switch (cell.getCellType())
               {
                   case STRING: String++; System.out.println(cell.getStringCellValue()); break;
                   case NUMERIC:num++; System.out.println(cell.getNumericCellValue()); break;
                   case BOOLEAN: bool++;System.out.println(cell.getBooleanCellValue()); break;
               }
            }
            System.out.println();
        }
       System.out.println("String count:" +String+"   "+"Number count is"+num+"  "+"boolean count is"+bool);
    }
}
