package com.pard.hw5.dto.student.response;

import com.pard.hw5.entity.student.Student;
import lombok.Data;

@Data
public class StudentInfoResponse {
    private Long id;
    private String name;
    private Integer gender;
    private Integer grade;
    private String birth;
    private String phoneNumber;

    public StudentInfoResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.gender = student.getGender();
        this.grade = student.getGrade();
        this.birth = student.getBirth();
        this.phoneNumber = student.getPhoneNumber();
    }
}
