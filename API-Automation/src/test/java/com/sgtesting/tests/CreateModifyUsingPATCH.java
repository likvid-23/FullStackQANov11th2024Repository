package com.sgtesting.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class CreateModifyUsingPATCH {
    public String employee_ID=null;
    @Test(priority = 1)
    public void createEmployee() {
        try{
            RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees";
            RequestSpecification httpRequest = RestAssured.given();
            String filename="./datafiles/createEmployee.json";
            File file=new File(filename);
            httpRequest.header("Content-Type","application/json");
            httpRequest.body(file);
            Response response = httpRequest.post();
            response.prettyPrint();
            employee_ID=response.jsonPath().getString("id");
            System.out.println("Employee ID : "+employee_ID+" created successfully");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    public void modifyEmployee()
    {
        try {
            RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees/"+employee_ID;
            RequestSpecification httpRequest = RestAssured.given();
            String filename="./datafiles/partiallyModifyEmployee.json";
            File file=new File(filename);
            httpRequest.header("Content-Type","application/json");
            httpRequest.body(file);
            Response response = httpRequest.patch();
            response.prettyPrint();
            System.out.println("Employee ID : "+employee_ID+" modified successfully");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 3)
    public void deleteEmployee()
    {
        try {
            RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees/"+employee_ID;
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type","application/json");
            Response response = httpRequest.delete();
            response.prettyPrint();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
