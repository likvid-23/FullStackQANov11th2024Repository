package com.sgtesting.pojotests;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;


public class UserPojo {
    public static String jsonobject=null;
    public static void main(String[] args) {

createJsonObject1();
//createJsonObject2();
        //createArrayOfJsonObject();
       // mapToJson();
    }
    public static String createJsonObject1()
    {
        try{
            Users obj=new Users("Santhosh","santhosh@gss.com","Dallas");
            ObjectMapper mapper=new ObjectMapper();
            jsonobject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(jsonobject);
            return jsonobject;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private static void createJsonObject2()
    {
        try{
            Users obj=new Users();
            obj.setFirstName("Vinith");
            obj.setEmailId("vinith@gmail.com");
            obj.setLocation("california");
            ObjectMapper mapper=new ObjectMapper();
            String jsonobject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(jsonobject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void createArrayOfJsonObject()
    {
        try{
            Users obj[]={new Users("Adams","adam@gmail.com","Johansberg"),
                    new Users("Cumminns","pat@gmail.com","Melbourne"),
                    new Users("Williamson","kane@gmail.com","Wellington")};
            ObjectMapper mapper=new ObjectMapper();
            jsonobject=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(jsonobject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void mapToJson()
    {
        try{
            Map<String,String> obj=new HashMap<>();
            obj.put("firstName","Vinith");
            obj.put("emailId","<EMAIL>");
            obj.put("location","california");
            ObjectMapper mapper=new ObjectMapper();
            jsonobject=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(jsonobject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
