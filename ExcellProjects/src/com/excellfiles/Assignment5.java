package com.excellfiles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Assignment5 {
    public static void main(String[] args) {
        writePersons();
        readwritePersons();
    }

    public static void writePersons()
    {
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh=null;
        Row row=null;
        Cell cell=null;
        String persons[]={"Sachin","Sehwag","Dravid","Ganguly","Yuvaraj","Kaif","Harbhajan","Kumble","Nehra","Javagal","Zaheer"};
        System.out.println("Number of Persons :"+persons.length);
        try
        {
            fout=new FileOutputStream("D:\\ExcelFiles\\Person.xlsx");
            wb=new XSSFWorkbook();
            sh=wb.createSheet("Sheet1");
            for(int i=0;i<11;i++)
            {
                row=sh.createRow(i);
                cell=row.createCell(0);
                cell.setCellValue(persons[i]);
            }

            wb.write(fout);

        } catch (Exception e) {
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

    public static void readwritePersons()
    {
        FileInputStream fin=null;
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh1=null;
        Row row1=null;
        Cell cell1=null;
        Sheet sh2=null;
        Row row2=null;
        Cell cell2=null;
        try
        {
            fin=new FileInputStream("D:\\ExcelFiles\\Person.xlsx");
            wb=new XSSFWorkbook(fin);
            sh1= wb.getSheet("Sheet1");
            sh2=wb.createSheet("Sheet2");
            int r = sh1.getPhysicalNumberOfRows();
            System.out.println("Number of Persons :"+r);
            ArrayList<String> lst=new ArrayList<String>();
            for(int i=0;i<r;i++)
            {
               row1= sh1.getRow(i);
               row2=sh2.createRow(i);
                int c = row1.getPhysicalNumberOfCells();

                for (int j=0;j<c;j++)
               {
                   cell1=row1.getCell(j);
                   cell2=row2.createCell(j);
                   String data = cell1.getStringCellValue();
                   lst.add(data);
                   for(int k=lst.size()-1;k>=0;i--)
                   {
                       cell2.setCellValue(lst.get(k));
                   }
               }

            }
            for (String l: lst)
            {
                System.out.println(l);
            }
            fout=new FileOutputStream("D:\\ExcelFiles\\Person.xlsx");
            wb.write(fout);




        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                fout.close();
                fin.close();
                wb.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
}
