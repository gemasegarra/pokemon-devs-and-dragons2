package com.ironhack.trainersservice.controller.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TrainerInputDTO {
    @NotEmpty(message = "Trainer name is required")
    private String name;
    @NotNull(message="Age required")
    private int age;
    private String hobby;
    private String picture;

    public TrainerInputDTO() {
    }

    public TrainerInputDTO(String name, int age, String hobby, String picture) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.picture = picture;
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
