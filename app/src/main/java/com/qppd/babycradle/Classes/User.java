package com.qppd.babycradle.Classes;

public class User {

    private String username;
    private String email;
    private String firstname;
    private String middlename;
    private String lastname;
    private String contact;
    private int gender;
    private int age;
    private int status;
    private String interests;

    public User(String username, String email, String firstname, String middlename,
                String lastname, String contact, int gender, int age, int status,
                String interests) {
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.contact = contact;
        this.gender = gender;
        this.age = age;
        this.status = status;
        this.interests = interests;
    }

    public User(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}
