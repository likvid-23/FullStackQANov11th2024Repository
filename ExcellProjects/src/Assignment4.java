import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class Assignment4 {
    public static void main(String[] args) {
        writeCities();
    }

    public static void writeCities()
    {
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh=null;
        Row row=null;
        Cell cell=null;
        String cities[]={"Bangalore","Chennai","Hyderabad","Mumbai","Kochi","Mysore","Hubli","Belgaum","Mangalore","Pondichery","Vizag","Trivendrum","Pune","Delhi","Kolkata","Bhopal","Ahmadabad","Jaipur","Lucknow","Patna"};
        System.out.print("Number of cities ="+cities.length);
        try
        {
            fout=new FileOutputStream("D:\\ExcelFiles\\Cities.xlsx");
            wb=new XSSFWorkbook();
            sh=wb.createSheet("Sheet1");
            for(int i=0;i<19;i++)
            {
                row= sh.createRow(i);
                for(int j=0;j<19;j++)
                {
                cell=row.createCell(j);
              if(i==j)
              {  cell.setCellValue(cities[j]);}

                }
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
