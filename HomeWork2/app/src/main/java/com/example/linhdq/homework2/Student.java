package com.example.linhdq.homework2;

/**
 * Created by LinhDQ on 4/5/2016.
 */
public class Student {
    private String name;
    private String classes;
    private String birthday;
    private String birth_place;
    private String hobby;
    private String gender;

    public Student() {

    }

    public Student(String name, String classes, String birthday, String birth_place, String hobby, String gender){
        this.name=name;
        this.classes=classes;
        this.birthday=birthday;
        this.birth_place=birth_place;
        this.hobby=hobby;
        this.gender=gender;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
