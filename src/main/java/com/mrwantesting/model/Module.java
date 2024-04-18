package com.mrwantesting.model;

public class Module {
    private int id;
    private String NameOfModules;
    private String formsOfModules1;
    private String formsOfModules2;
    private String formsOfModules3;
    public Module() {
    }

    public Module(int id, String nameOfModules, String formsOfModules1, String formsOfModules2, String formsOfModules3) {
        this.id = id;
        this.NameOfModules = nameOfModules;
        this.formsOfModules1 = formsOfModules1;
        this.formsOfModules2 = formsOfModules2;
        this.formsOfModules3 = formsOfModules3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfModules() {
        return NameOfModules;
    }

    public void setNameOfModules(String nameOfModules) {
        NameOfModules = nameOfModules;
    }

    public String getFormsOfModules1() {
        return formsOfModules1;
    }

    public void setFormsOfModules1(String formsOfModules1) {
        this.formsOfModules1 = formsOfModules1;
    }

    public String getFormsOfModules2() {
        return formsOfModules2;
    }

    public void setFormsOfModules2(String formsOfModules2) {
        this.formsOfModules2 = formsOfModules2;
    }

    public String getFormsOfModules3() {
        return formsOfModules3;
    }

    public void setFormsOfModules3(String formsOfModules3) {
        this.formsOfModules3 = formsOfModules3;
    }

    @Override
    public String toString() {
        return "module{" +
                "id=" + id +
                ", NameOfModules='" + NameOfModules + '\'' +
                ", formsOfModules1='" + formsOfModules1 + '\'' +
                ", formsOfModules2='" + formsOfModules2 + '\'' +
                ", formsOfModules3='" + formsOfModules3 + '\'' +
                '}';
    }
}
