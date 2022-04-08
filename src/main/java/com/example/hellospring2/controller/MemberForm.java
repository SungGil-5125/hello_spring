package com.example.hellospring2.controller;


public class MemberForm {
    private String name; //spring이 html에서 name을 찾아서 값을 넣어준다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
