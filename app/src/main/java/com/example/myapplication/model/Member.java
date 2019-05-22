package com.example.myapplication.model;

public final class Member extends BaseModel {

    private String name;

    public Member() {
    }


    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
