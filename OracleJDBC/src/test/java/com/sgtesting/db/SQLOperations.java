package com.sgtesting.db;

import java.sql.*;

public class SQLOperations {
    public static void main(String[] args) {
       //readRecords();
       insertRecords();
    }
     private static void readRecords()
     {
         Connection conn=null;
         try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
             conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","tiger");
             System.out.println("Connection established successfully");
             Statement stmt=conn.createStatement();
             String query="select * from dept";
             ResultSet rs=stmt.executeQuery(query);
             ResultSetMetaData rsmeta = rs.getMetaData();
             String colname1 = rsmeta.getColumnName(1);
             String colname2 = rsmeta.getColumnName(2);
             String colname3 = rsmeta.getColumnName(3);
             System.out.printf("%-12s",colname1);
             System.out.printf("%-12s",colname2);
             System.out.printf("%-12s",colname3);
             System.out.printf("\n");
             while (rs.next())
             {
                 String deptno=rs.getString("DEPTNO");
                 String deptname = rs.getString("DNAME");
                 String place = rs.getString("LOC");
                 System.out.printf("%-12s",deptno);
                 System.out.printf("%-12s",deptname);
                 System.out.printf("%-12s",place);
                 System.out.printf("\n");
             }

         } catch (Exception e) {
             throw new RuntimeException(e);
         }
         finally {
             try {
                 conn.close();
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }
     }
     private static void insertRecords()
     {
         Connection conn=null;
         try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
          conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
             System.out.println("Connection Established Successfully");
             Statement stmt = conn.createStatement();
             String query="insert into dept values(60,'MARKETING1','BANGALORE1')";
             int result = stmt.executeUpdate(query);
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
         finally {
             try {
                 conn.close();
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }
     }
}
