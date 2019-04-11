package com.example.re;

public class FriendsInfo {
    private String name;
    private String ip;

    public FriendsInfo(String name, String ip) {
        this.name=name;
        this.ip=ip;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
