package com.excellfiles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcellFileContent
{
    public static void main(String[] args) {
        readFile();
    }
    public static void readFile()
    {
        FileInputStream fin=null;
 Workbook wb=null;
 Sheet sh=null;
 Row row=null;
 Cell cell=null;
    try{
        fin=new FileInputStream("D:\\ExcelFiles\\Sample.xlsx");
      wb=new XSSFWorkbook(fin);
      sh=wb.getSheet("Sheet1");
     int rw=sh.getPhysicalNumberOfRows();
     System.out.println("Number of rows : "+rw);
     for(int r=0;r<rw;r++)
        {
            row=sh.getRow(r);
            int cll=row.getPhysicalNumberOfCells();
            for(int c=0;c<cll;c++)
            {
                cell=row.getCell(c);
                String data = cell.getStringCellValue();
                System.out.print(data);
                System.out.print("\t");
            }
            System.out.println("\n");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    finally {
        try{
            fin.close();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

}
