package com.ironhack.trainersservice.model;

import com.ironhack.trainersservice.enums.Hobby;

import javax.persistence.*;
import java.util.Date;


@Entity

public class Trainer {
    @Id
    @Column(unique=true,nullable = false)
    private String name;
    private byte age;
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

    public Trainer(String name, byte age, Hobby hobby, String picture) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.picture = picture;
    }

    public Trainer(String name, byte age, Hobby hobby, String picture, Date creationDate) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.picture = picture;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
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


