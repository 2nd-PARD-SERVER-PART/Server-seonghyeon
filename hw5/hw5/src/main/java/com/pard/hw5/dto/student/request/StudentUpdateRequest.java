package com.pard.hw5.dto.student.request;

import lombok.Data;

@Data
public class StudentUpdateRequest {
    private String name;
    private Integer gender;
    private Integer grade;
    private String birth;
    private String phoneNumber;
}
