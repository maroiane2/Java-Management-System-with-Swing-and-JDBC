package com.mrwantesting.model;

public class Employeeteachers {
    private int id;
    private String Firstname;
    private String Surname;
    private String city;
    private int age;
    public Employeeteachers() {
    }

    public Employeeteachers(int id, String firstname, String surname, String city, int age) {
        this.id = id;
        Firstname = firstname;
        Surname = surname;
        this.city = city;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employeeteachers{" +
                "id=" + id +
                ", Firstname='" + Firstname + '\'' +
                ", Surname='" + Surname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
