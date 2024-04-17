package com.mrwantesting.model;

public class Employeeforms {

        private int id;
        private String name;
        private String teacher;
        private int times;

    public Employeeforms() {
    }

    public Employeeforms(int id, String name, String teacher, int times) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.times = times;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Employeeforms{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", times=" + times +
                '}';
    }
}
