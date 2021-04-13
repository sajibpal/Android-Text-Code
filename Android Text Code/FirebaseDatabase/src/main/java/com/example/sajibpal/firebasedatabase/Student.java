package com.example.sajibpal.firebasedatabase;

import com.google.firebase.database.Exclude;

/**
 * Created by sajib pal on 4/12/2019.
 */

public class Student {

    String name;
    String age;
    String key;

    public Student(){

    }

    @Exclude
    public String getKey() {
        return key;
    }
    @Exclude
    public void setKey(String key) {
        this.key = key;
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
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




}
