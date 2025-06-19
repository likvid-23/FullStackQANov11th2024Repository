package com.sgtesting.pojotests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;


public class CreateEmployeeScenario {
    private static String employee_id;

    @Test(priority = 1)
    public void createEmployee() {
        try {
            RestAssured.baseURI = "http://localhost:9090/sgtesting/api/v1/employees";
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", "application/json");
            Employee obj = new Employee();
            obj.setEmployeeFirstName("likith");
            obj.setEmployeeLastName("bhushan");
            obj.setEmailId("likithth@gmail.com");
            obj.setAge(35);
            obj.setSalary(45000L);
            obj.setAddress("4th Stage, 5th Cross, 8th Main, Madhugiri");
            obj.setCityName("madhugiri");
            obj.setContactNumber(7676759273L);
            obj.setDepartmentName("Operations");
            obj.setJobName("Automation Engineer");
            ObjectMapper mapper = new ObjectMapper();
            String employeeObject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(employeeObject);
            httpRequest.body(employeeObject);
            Response response = httpRequest.post();
            response.prettyPrint();
            String content = response.prettyPrint();
            System.out.println(content);
            JsonPath jpath = response.jsonPath();
            employee_id = jpath.getString("id");
            System.out.println("Employee Id :" + employee_id);
            Assert.assertEquals(201,response.getStatusCode());
            Assert.assertNotNull(response);
            Assert.assertTrue(Integer.parseInt(employee_id) != 0);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    public void displayEmployee() {
        try {
            RestAssured.baseURI = "http://localhost:9090/sgtesting/api/v1/employees/" + employee_id;
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", "application/json");
            Response response = httpRequest.get();
            response.prettyPrint();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 3)
    public void deleteEmployee() {
        try {
            RestAssured.baseURI = "http://localhost:9090/sgtesting/api/v1/employees/" + employee_id;
            RequestSpecification httpRequest = RestAssured.given();
            httpRequest.header("Content-Type", "application/json");
            Response response = httpRequest.delete();
            response.prettyPrint();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
