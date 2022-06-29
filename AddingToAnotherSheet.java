package com.kodnest.assignment;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.Arrays;

public class AddingToAnotherSheet {
    public static void main(String[] args) throws IOException {
        int i=0;

        String excelFilePath=".\\datafiles\\readInput.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook= new XSSFWorkbook(inputStream);

        XSSFSheet sheet1= workbook.getSheet("Sheet1");
        XSSFSheet sheet2= workbook.getSheet("Sheet2");

        int rows1= sheet1.getLastRowNum();
        int rows2= sheet2.getLastRowNum();

        int cols1=sheet1.getRow(1).getLastCellNum();
        int cols2=sheet2.getRow(1).getLastCellNum();

        XSSFSheet sheet3=workbook.createSheet("Sheet3");


        List<List> arr1=new ArrayList<>();

        for( i=0;i<rows1;i++){
            XSSFRow row1=sheet1.getRow(i);
            List key=new ArrayList<>();
            for(int j=0;j<cols1;j++){
               XSSFCell cell1= row1.getCell(j);
               key.add(j,cell1);
            }
            arr1.add(i,key);
        }

        for(i=0;i<arr1.size();i++){
            System.out.println(arr1.get(i).toString());
        }

        List<List> arr2=new ArrayList<>();

        for(i=0;i<rows2;i++){
            XSSFRow row2=sheet2.getRow(i);
            List key=new ArrayList<>();
            for(int j=0;j<cols2;j++){
                XSSFCell cell2= row2.getCell(j);
                key.add(j,cell2);
            }
            arr2.add(i,key);
        }

        for( i=0;i<arr2.size();i++){
            System.out.println(arr2.get(i).toString());
        }

        Object arr3[][]=new Object[rows1+rows2][cols1+cols2];
         for ( i=0;i<arr1.size();i++){
             arr3[i]=arr1.get(i).toArray();
            // arr3.add(i,arr1.get(i));
         }
         int valueOfi=i;
         boolean flag=false;
         List list1=arr1.get(0);
         List list2=arr2.get(0);
         for(int j=0;j<list2.size();j++){
             Object value=list2.get(j).toString();
             int k=0;
             for( k=0;k<list1.size();k++){
                 Object value2=list1.get(k).toString();
                 if(value.equals(value2)){
                     flag=true;
                     break;
                 }
             }
             if(flag){
                for(int z=1;z< arr2.size();z++) {
                     arr3[i][k]=arr2.get(z).get(j);
                      i++;
                 }
                i=valueOfi;
             }
             else{
                 for(int x=1;x< arr2.size();x++)
                 arr3[x][k]=arr2.get(x).get(j);

             }
         }

        System.out.println();
        for( i=0;i<arr3.length;i++){
            System.out.println(Arrays.toString(arr3[i]));
        }


       int rows= arr3.length;
       int cols= arr3[0].length;
       for( i=0;i<rows;i++){
           XSSFRow row=sheet3.createRow(i);
           for(int j=0;j<cols;j++){
               XSSFCell cell=row.createCell(j);
               Object value= arr3[i][j];

               if(value instanceof String){
                   cell.setCellValue((String) value);
               }
               if(value instanceof Integer){
                   cell.setCellValue((Integer) value);
               }
               if(value instanceof Boolean){
                   cell.setCellValue((Boolean) value);
               }
           }
       }
            String filepath=".\\datafiles\\readInput.xlsx";
        FileOutputStream outputStream=new FileOutputStream(filepath);
         workbook.write(outputStream);

         outputStream.close();

            }
        }



