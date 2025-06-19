package com.sgtesting.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgtesting.pojotests.Employee;
import com.sgtesting.utility.DataBaseUtility;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseLogSpec;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class EmployeeTests {
    @Test(enabled = false)
    public void employeeSchemaValidation(){
        String fileName=null;
        try{
            fileName="./datafiles/employeeschemadata.txt";
            String jsonSchema = FileUtils.readFileToString(new File(fileName));
            RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees/1";

            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type","application/json");
            Response response = httpRequest.get();
            response.prettyPrint();
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test(enabled = true)
    public  void createEmployeeValidateDB(){
        try{
            Employee obj=new Employee();
            obj.setEmployeeFirstName("Likith");
            obj.setAddress("vivekananda extension raghavendra colony");
            obj.setAge(35);
            obj.setJobName("Tset Engineer");
            obj.setEmailId("likith@gmail.com");
            obj.setEmployeeLastName("Bhushan");
            obj.setCityName("Madhugiri");
            obj.setContactNumber(7676759273l);
            obj.setDepartmentName("Testing");
            obj.setSalary(5667789l);
            ObjectMapper mapper=new ObjectMapper();
            String empObject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            RestAssured.baseURI="http://localhost:9090/sgtesting/api/v1/employees";
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type","application/json");
            httpRequest.body(empObject);
            Response response = httpRequest.post();
            response.prettyPrint();
            JsonPath jpath = response.jsonPath();
            String empID = jpath.getString("id");
            System.out.println("Expected Employee id :"+empID);
            String actual_empID = DataBaseUtility.getEmployeeID("SELECT * FROM (SELECT * FROM system.tbl_employees ORDER BY CREATED_AT DESC) WHERE rownum=1");
            System.out.println("Actual Employee ID :"+actual_empID);
            Assert.assertEquals(empID,actual_empID);
            System.out.println("Employee Creation and Validation is successfull");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
