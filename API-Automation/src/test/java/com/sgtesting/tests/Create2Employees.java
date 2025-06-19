package com.sgtesting.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Create2Employees {
public static String employee_id=null;
List<String> employees=new LinkedList<String>();
    @Test(priority = 1)
    public void create2Employees(){
try{
    RestAssured.baseURI = "http://localhost:9090/sgtesting/api/v1/employees";
    RequestSpecification httpRequest = RestAssured.given();
    String filename="./datafiles/createEmployee.json";
    File file=new File(filename);
    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(file);
    Response response = httpRequest.post();
    response.prettyPrint();
    JsonPath jPath = response.jsonPath();
    employee_id = jPath.getString("id");
    employees.add(employee_id);
    System.out.println("Employee ID of first employee: "+employee_id);
     response = httpRequest.post();
    response.prettyPrint();
     jPath = response.jsonPath();
    employee_id = jPath.getString("id");
    employees.add(employee_id);
    System.out.println("Employee ID of second employee: "+employee_id);
    System.out.println(employees);


} catch (Exception e) {
    throw new RuntimeException(e);
}
    }
@Test(priority = 2)
    public void displayEmployeeID()
    {
        try{
        String emp1 = employees.get(0);
        System.out.println(emp1);
       RestAssured.baseURI = "http://localhost:9090/sgtesting/api/v1/employees/"+emp1;
       RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        Response response = httpRequest.get();
        response.prettyPrint();
        String emp2 = employees.get(1);
        RestAssured.baseURI = "http://localhost:9090/sgtesting/api/v1/employees/"+emp2;
         httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        response = httpRequest.get();
        response.prettyPrint();} catch (Exception e) {
        throw new RuntimeException(e);
        }
    }

    @Test(priority = 3)
    public void delete2Employees()
    {
        try{
            String emp1 = employees.get(0);
            RestAssured.baseURI = "http://localhost:9090/sgtesting/api/v1/employees/"+emp1;
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type","application/json");
            Response response = httpRequest.delete();
            response.prettyPrint();
            String emp2 = employees.get(1);
            RestAssured.baseURI = "http://localhost:9090/sgtesting/api/v1/employees/"+emp2;
            httpRequest = RestAssured.given();
            httpRequest.header("Content-Type","application/json");
            response = httpRequest.delete();
            response.prettyPrint();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
