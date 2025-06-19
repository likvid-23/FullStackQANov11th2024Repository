package com.sgtesting.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class AppIndependent {

    public static Properties properties(String filepath) {
        Properties prop = null;
        FileInputStream fin = null;
        try {
            prop = new Properties();
            fin = new FileInputStream(filepath);
            prop.load(fin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fin.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return prop;

    }

    public static String getReportConfigPath()
    {
        String reportConfigPath=null;
        try{
            String path=System.getProperty("user.dir");
            Properties properties1 = properties(path+"\\Configs\\Configuration.properties");
            reportConfigPath=properties1.getProperty("reportConfigPath");
            if(reportConfigPath!= null)
            {return reportConfigPath;}
            else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
