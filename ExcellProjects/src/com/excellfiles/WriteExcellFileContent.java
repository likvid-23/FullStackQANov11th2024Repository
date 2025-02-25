package com.excellfiles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class WriteExcellFileContent {
    public static void main(String[] args) {
        writeContent();
    }
    public static void writeContent(){
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh=null;
        Row row=null;
        Cell cell=null;
        try{
            fout=new FileOutputStream("D:\\ExcelFiles\\Sample.xlsx");
            wb=new XSSFWorkbook();
            sh=wb.createSheet("Sheet1");
            row=sh.createRow(0);
            cell=row.createCell(0);
            cell.setCellValue("Name :");
            cell=row.createCell(1);
            cell.setCellValue("Samvid");
            row=sh.createRow(1);
            cell=row.createCell(0);
            cell.setCellValue("Father Name :");
            cell=row.createCell(1);
            cell.setCellValue("Likith");
            row=sh.createRow(2);
            cell=row.createCell(0);
            cell.setCellValue("Mother Name :");
            cell=row.createCell(1);
            cell.setCellValue("Chaitra");

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
}
