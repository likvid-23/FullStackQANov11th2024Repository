package com.serialization;

import java.io.Serializable;
import java.security.PrivateKey;

public class Student implements Serializable {
    private int rollNo;
    private String firstname;
    private String lastname;

    public Student(int rollNo,String firstname,String lastname)
    {
        this.firstname=firstname;
        this.rollNo=rollNo;
        this.lastname=lastname;
    }

    public void showRollNo()
    {
        System.out.println("Roll Number of the student :"+rollNo);
    }
    public void showFirstName()
    {
        System.out.println("First name of the Student :"+firstname);
    }
    public void showLastName()
    {
        System.out.println("Last name of the Student :"+lastname);
    }
}
