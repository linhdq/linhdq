package com.example.linhdq.homework;

/**
 * Created by LinhDQ on 4/7/2016.
 */
public class Employee {
    private String name;
    private String gender;
    private int age;
    private String birthPlace;
    private String hobby;

    public Employee(String name, String gender, int age, String birthPlace, String hobby) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthPlace = birthPlace;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
