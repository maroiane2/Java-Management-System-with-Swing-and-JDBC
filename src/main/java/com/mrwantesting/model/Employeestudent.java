package com.mrwantesting.model;

import java.util.Date;

public class Employeestudent {
    private int id;
    private String Firstname;
    private String Surname;
    private String city;
    private String fields;
    private int age;

    public Employeestudent() {
    }

    public Employeestudent(int id, String firstname, String surname, String city, String fields, int age) {
        this.id = id;
        Firstname = firstname;
        Surname = surname;
        this.city = city;
        this.fields = fields;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employeestudent{" +
                "id=" + id +
                ", Firstname='" + Firstname + '\'' +
                ", Surname='" + Surname + '\'' +
                ", city='" + city + '\'' +
                ", fields='" + fields + '\'' +
                ", age=" + age +
                '}';
    }
}
