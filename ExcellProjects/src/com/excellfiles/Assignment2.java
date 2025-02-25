package com.excellfiles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class Assignment2 {
    public static void main(String[] args) {
        writefruits();
    }

    public static void writefruits()
    {
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh=null;
        Row row=null;
        Cell cell=null;
        String fruits[] = {"Apple", "Banana", "Mango", "JackFruit", "Lichie", "Star Fruit", "Orange", "Grapes", "Sapota", "Mosambi", "Avacado", "Papaya", "Guava", "Strawberry","Purple Fruit"};
        System.out.print("Number of Fruits ="+fruits.length);
        try
        {
            fout=new FileOutputStream("D:\\ExcelFiles\\FruitsList.xlsx");
            wb=new XSSFWorkbook();
            sh=wb.createSheet("Sheet1");

            row= sh.createRow(9);
                 for(int j=0;j<14;j++) {
                     cell = row.createCell(j);
                     cell.setCellValue(fruits[j]);

             }
                 wb.write(fout);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                fout.close();
                wb.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
