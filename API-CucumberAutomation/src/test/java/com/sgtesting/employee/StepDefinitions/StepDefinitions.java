package com.sgtesting.employee.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.io.File;

public class StepDefinitions {

    private static final Logger log = LogManager.getLogger(StepDefinitions.class);
    public static RequestSpecification httpRequest = null;
    public static Response response = null;
    public static File createEmployeeJsonFile = null;
    public static String employee_id;

    @Given("^I provide Post Employee (.*) End Point$")
    public void I_provide_Post_Employee_Request_EndPoint(String request) {
        try {
            log.info("I provide Post Employee Request EndPoint");
            RestAssured.baseURI = request;
        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }
    }

    @Given("I create RequestSpecification object")
    public void i_create_request_specification_object() {
        try {
            log.info("I Create Request Specification Object");
            httpRequest = RestAssured.given();

        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }
    }

    @Given("I provide the Request header")
    public void i_provide_the_request_header() {
        try {
            log.info("I provide request header");
            httpRequest.header("Content-Type", "application/json");

        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }
    }

    @Given("I provide the Request Body")
    public void i_provide_the_request_body() {
        try {
            log.info("I provide request Body");
            String createEmployeeFile = "./DataFiles/createemployee.json";
            createEmployeeJsonFile = new File(createEmployeeFile);
            httpRequest.body(createEmployeeJsonFile);

        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }
    }

    @When("I run the POST http Method")
    public void i_run_the_post_http_method() {
        try {
            log.info("I run the POST http Method");
            response = httpRequest.post();
            response.prettyPrint();

        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }


    }

    @Then("I get the status code as {int}")
    public void i_get_the_status_code_as(Integer statuscode) {
        try {
            log.info("I get the status code as {int}");
            int actualstatuscode = response.getStatusCode();
            Assert.assertEquals(actualstatuscode, statuscode);

        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }

    }

    @Then("I store the employee ID variable")
    public void i_store_the_employee_id_variable() {
        try {
            JsonPath jpath = response.jsonPath();
            employee_id = jpath.getString("id");
            System.out.println("Employee ID : " + employee_id);
        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }
    }

    @Given("I provide Get Employee (.*) Endpoint$")
    public void I_provide_Get_Employee_Request_EndPoint(String request) {
        try {
            log.info("I provide Get Employee Request EndPoint");
            RestAssured.baseURI = request + "/" + employee_id;
        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }
    }

    @When("I run the GET http Method")
    public void i_run_the_get_http_method() {
        try {
            log.info("I run the GET http Method");
            response = httpRequest.get();
            response.prettyPrint();

        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }
    }

    @Given("I provide Delete Employee (.*) Endpoint$")
    public void I_provide_Delete_Employee_Request_EndPoint(String request) {
        try {
            log.info("I provide Get Employee Request EndPoint");
            RestAssured.baseURI = request + "/" + employee_id;
        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }
    }

    @When("I run the DELETE http Method")
    public void i_run_the_delete_http_method() {
        try {
            log.info("I run the DELETE http Method");
            response = httpRequest.delete();
            response.prettyPrint();

        } catch (Exception e) {
            log.error("there is a Error message has occured during execution of I_provide_Post_Employee_Request_EndPoint, Exception :" + e);
        }
    }

}
