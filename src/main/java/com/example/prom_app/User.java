package com.example.prom_app;

import java.io.Serializable;

public class User implements Serializable {
    String user_name, ID;
    String name,age, location;
    String gen;
    int year,month,day;

    public User(String name, String location, String gen, int year, int month, int day) {
        this.name = name;
        this.location = location;
        this.gen = gen;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public User(String user_name, String ID, String name, String age, String location, String gen) {
        this.user_name = user_name;
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.location = location;
        this.gen = gen;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }
}
