package com.anjukakoralage.hondapromo;

/**
 * Created by anjukakoralage on 22,July,2019
 */
public class UserDetails {

    String name;
    String age;
    String city;
    String tp;

    public UserDetails(){

    }

    public UserDetails(String name, String age, String city, String tp) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.tp = tp;
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
}
