package com.ironhack.trainersservice.controller.dto;

import javax.validation.constraints.NotEmpty;

public class TrainerDTO {
    @NotEmpty(message = "Trainer name is required")
    private String name;
    private int age;
    @NotEmpty(message = "Trainer hobby is required")
    private String hobby;
    @NotEmpty(message = "A picture is required")
    private String picture;

    public TrainerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Trainer:" +
                "Name: " + name + '\'' +
                "Age: " + age +
                "Hobby: " + hobby + '\'' +
                "Picture: " + picture + '\''
                ;
    }
}
