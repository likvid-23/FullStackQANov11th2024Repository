package com.sgtesting.db;

import java.sql.*;

public class SQLOperationsUsingPreparedStatement {
    public static void main(String[] args) {
        readRecordsFromDataBase();

    }
    private static void readRecordsFromDataBase()
    {
        Connection conn=null;
       try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
           System.out.println("connection established successfully");
           String query = "select * from emp";
           PreparedStatement stmt = conn.prepareStatement(query);
           ResultSet rs= stmt.executeQuery();
           ResultSetMetaData rsmeta = rs.getMetaData();
           String colname1 = rsmeta.getColumnName(1);
           String colname2 = rsmeta.getColumnName(2);
           String colname3 = rsmeta.getColumnName(3);
           String colname4 = rsmeta.getColumnName(4);
           String colname5 = rsmeta.getColumnName(5);
           String colname6 = rsmeta.getColumnName(7);
           String colname7 = rsmeta.getColumnName(7);
           String colname8 = rsmeta.getColumnName(8);
           System.out.printf("%-12s",colname1);
           System.out.printf("%-12s",colname2);
           System.out.printf("%-12s",colname3);
           System.out.printf("%-12s",colname4);
           System.out.printf("%-12s",colname5);
           System.out.printf("%-12s",colname6);
           System.out.printf("%-12s",colname7);
           System.out.printf("%-12s",colname8);
           System.out.printf("\n");
         while (rs.next())
         {
             String empno = rs.getString("EMPNO");
             String ename=rs.getString("ENAME");
             String job=rs.getString("JOB");
             String manager = rs.getString("MGR");
             String hiredate = rs.getString("HIREDATE");
             String salary=rs.getString("SAL");
             String comm=rs.getString("COMM");
             String deptno= rs.getString("DEPTNO");
             System.out.printf("%-12s",empno);
             System.out.printf("%-12s",ename);
             System.out.printf("%-12s",job);
             System.out.printf("%-12s",manager);
             System.out.printf("%-12s",hiredate);
             System.out.printf("%-12s",salary);
             System.out.printf("%-12s",comm);
             System.out.printf("%-12s",deptno);

             System.out.printf("\n");
         }


       } catch (Exception e) {
           throw new RuntimeException(e);
       }
       finally {
           try{} catch (Exception e) {
               throw new RuntimeException(e);
           }
       }
    }

}
