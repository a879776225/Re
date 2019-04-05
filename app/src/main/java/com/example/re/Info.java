package com.example.re;

public class Info {
    private String idnum;
    private String dean;
    private String classname;
    private String name;
    private String adress;
    private String brithday;
    private String lunar_brithday;

    public  Info(String idnum, String dean, String classname, String name, String adress, String brithday, String lunar_brithday) {
        this.idnum=idnum;
        this.dean=dean;
        this.classname=classname;
        this.name=name;
        this.adress=adress;
        this.brithday=brithday;
        this.lunar_brithday=lunar_brithday;
    }

    public String getName() {
        return name;
    }

    public String getClassname() {
        return classname;
    }
}
