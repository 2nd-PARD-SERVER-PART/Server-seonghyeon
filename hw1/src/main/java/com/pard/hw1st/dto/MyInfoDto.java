package com.pard.hw1st.dto;

public class MyInfoDto {
    private final String major;       // 전공
    private final int grade;          // 학년
    private final int age;            // 나이
    private final String hobby;       // 취미
    private final String name;        // 이름
    private final String hometown;    // 고향
    private final String introduction; // 자기소개

    // 생성자
    public MyInfoDto(String major, int grade, int age, String hobby, String name, String hometown, String introduction) {
        this.major = major;
        this.grade = grade;
        this.age = age;
        this.hobby = hobby;
        this.name = name;
        this.hometown = hometown;
        this.introduction = introduction;
    }

    public String getMajor() {
        return major;
    }

    public int getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public String getHobby() {
        return hobby;
    }

    public String getName() {
        return name;
    }

    public String getHometown() {
        return hometown;
    }

    public String getIntroduction() {
        return introduction;
    }
}
