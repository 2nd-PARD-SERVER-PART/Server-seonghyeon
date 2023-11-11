package com.pard.hw5.dto.student.request;

import com.pard.hw5.entity.student.Student;
import lombok.Data;

@Data
public class StudentCreateRequest {
    private String name;
    private Integer gender;
    private Integer grade;
    private String birth;
    private String phoneNumber;

    // builder -> 생성자 순서 상관 X
    public Student toEntity() {
        return Student.builder()
                .name(name)
                .gender(gender)
                .grade(grade)
                .birth(birth)
                .phoneNumber(phoneNumber)
                .build();

    }

}
