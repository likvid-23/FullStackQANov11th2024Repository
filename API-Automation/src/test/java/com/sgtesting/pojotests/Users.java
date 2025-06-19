package com.sgtesting.pojotests;

public class Users {
    private String firstName;
    private String emailId;
    private String location;

    public Users(){

    }
    public Users(String firstName, String emailId, String location) {
        this.firstName = firstName;
        this.emailId = emailId;
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
