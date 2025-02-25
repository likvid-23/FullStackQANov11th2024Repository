package com.excellfiles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class Assignment3 {
    public static void main(String[] args) {
        writeColors();
    }

    public static void writeColors()
    {
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh=null;
        Row row=null;
        Cell cell=null;
        String colors[]={"Red","Blue","Green","Orange","violet","Saffron","purple","pink","black","white","gray","brown","skyblue"};
        System.out.print("Number of colors ="+colors.length);
        try
        {
            fout=new FileOutputStream("D:\\ExcelFiles\\Colors.xlsx");
            wb=new XSSFWorkbook();
            sh=wb.createSheet("Sheet1");
            for(int i=0;i<13;i++)
            {
                row= sh.createRow(i);
                cell=row.createCell(4);
                cell.setCellValue(colors[i]);
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
