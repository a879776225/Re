package com.example.re;

public class Info {
    private String idnum;
    private String dean;
    private String classname;
    private String name;
    private String adress;
    private String brithdate;
    private String lunar_brithday;
    private String city;
    private String phonenum;
    private String md;


    public  Info(String idnum, String dean, String classname, String name, String adress,
                 String brithdate, String lunar_brithday,String city,String mbphone,String md) {
        this.idnum=idnum;
        this.dean=dean;
        this.classname=classname;
        this.name=name;
        this.adress=adress;
        this.brithdate = brithdate;
        this.md = md;
        this.city = city;
        this.phonenum = mbphone;
        this.lunar_brithday = lunar_brithday;

    }

    public String getName() {
        return name;
    }

    public String getClassname() {
        return classname;
    }

    public String getAdress() {
        return adress;
    }

    public String getBrithdate() {
        return brithdate;
    }

    public String getDean() {
        return dean;
    }

    public String getCity() {
        return city;
    }

    public String getIdnum() {
        return idnum;
    }

    public String getLunar_brithday() {
        return lunar_brithday;
    }

    public String getMd() {
        return md;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setBrithdate(String brithdate) {
        this.brithdate = brithdate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public void setLunar_brithday(String lunar_brithday) {
        this.lunar_brithday = lunar_brithday;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

}
