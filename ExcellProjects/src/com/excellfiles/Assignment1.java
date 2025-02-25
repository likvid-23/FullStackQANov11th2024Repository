package com.excellfiles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Assignment1 {
    public static void main(String[] args) {
        writeflowers();
    }

    public static void writeflowers()
    {
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh=null;
        Row row=null;
        Cell cell=null;
        String flowers[]={"Rose","lilly","Jasmine","poppy","BlueBell","Haibiscus","Daisy","Daffodil","Iris","Orchid","MaryGold","Lavender","Tulip","Sunflower","Lotus"};
        System.out.print("Number of flowers ="+flowers.length);
        try
        {
            fout=new FileOutputStream("D:\\ExcelFiles\\Flowers.xlsx");
            wb=new XSSFWorkbook();
            sh=wb.createSheet("Sheet1");
          for(int i=0;i<14;i++)
          {
             row= sh.createRow(i);
             cell=row.createCell(0);
             cell.setCellValue(flowers[i]);
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
