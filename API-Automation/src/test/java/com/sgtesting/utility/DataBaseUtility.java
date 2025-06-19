package com.sgtesting.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseUtility {
    public static void main(String[] args) {
        String data = getEmployeeID("SELECT * FROM (SELECT * FROM system.tbl_employees ORDER BY CREATED_AT DESC) WHERE rownum=1");
        System.out.println(data);
    }

    public static String getEmployeeID(String Query) {
        Connection conn = null;
        String empID = null;
        String job = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
            System.out.println("connection successfull");
            PreparedStatement stmt = conn.prepareStatement(Query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            empID = rs.getString("id");


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return empID;
    }
}
