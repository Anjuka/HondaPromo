package com.anjukakoralage.hondapromo.Utils;

/**
 * Created by anjukakoralage on 22,July,2019
 */
public class UserDetails {

    String name;
    String age;
    String city;
    String tp;
    String dateTime;

    public UserDetails(){

    }

    public UserDetails(String name, String age, String city, String tp, String dateTime) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.tp = tp;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getTp() {
        return tp;
    }
    public String getDateTime() {
        return dateTime;
    }
}
