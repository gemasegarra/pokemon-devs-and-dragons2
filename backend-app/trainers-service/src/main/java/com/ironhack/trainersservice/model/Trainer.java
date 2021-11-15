package com.ironhack.trainersservice.model;

import com.ironhack.trainersservice.enums.Hobby;

import javax.persistence.*;
import java.util.Date;


@Entity

public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    @Enumerated(value = EnumType.STRING)
    private Hobby hobby;
    @Column(name="photo")
    private String picture;
    private Date creationDate;
    private Date modificationDate;
    private String userCreation;
    private String userModification;

    public Trainer() {
    }

    public Trainer(String name, int age, Hobby hobby, String picture) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.picture = picture;
    }

    public Trainer(long id, String name, int age, Hobby hobby, String picture) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.picture = picture;
    }

    public Trainer(String name, int age, Hobby hobby, String picture, Date creationDate) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.picture = picture;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public String getUserModification() {
        return userModification;
    }

    public void setUserModification(String userModification) {
        this.userModification = userModification;
    }
}


