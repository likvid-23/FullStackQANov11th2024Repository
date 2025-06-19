package com.sgtesting.tests;

import com.sgtesting.pojotests.UserPojo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;


public class CreateEmployee {

    public static String employee_id=null;
    @Test(priority = 1)
    public void createEmployee() {
        try {
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
            System.out.println("Employee ID : "+employee_id);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 2)
    public void displayEmployee()
    {
        try {
            RestAssured.baseURI = "http://localhost:9090/sgtesting/api/v1/employees/"+employee_id;
            RequestSpecification httpRequest = RestAssured.given();

            httpRequest.header("Content-Type", "application/json");
            Response response = httpRequest.get();
             response.prettyPrint();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
@Test(priority = 3 , enabled = true)
    public void deleteEmployee()
    {
        try{
            RestAssured.baseURI = "http://localhost:9090/sgtesting/api/v1/employees/"+employee_id;
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", "application/json");
            Response response = httpRequest.delete();
              response.prettyPrint();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 4,enabled = true)
    public void displayAllTheEmployees()
    {
       RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        Response response = httpRequest.get();
        response.prettyPrint();
    }

}
