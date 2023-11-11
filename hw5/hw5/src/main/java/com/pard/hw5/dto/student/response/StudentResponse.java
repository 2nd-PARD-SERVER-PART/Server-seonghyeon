package com.pard.hw5.dto.student.response;

import com.pard.hw5.dto.enrollment.response.EnrollmentStudentResponse;
import com.pard.hw5.entity.student.Student;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentResponse {
    private Long id;
    private String name; // 학생 이름
    private Integer gender; // 성별
    private Integer grade; // 학년
    private String birth; // 생일
    private String phoneNumber; // 전화번호
    private List<EnrollmentStudentResponse> enrollments; // 수강 과목

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.gender = student.getGender();
        this.grade = student.getGrade();
        this.birth = student.getBirth();
        this.phoneNumber = student.getPhoneNumber();

//        if (student.getEnrollments() != null) {
//            this.enrollments = student.getEnrollments().stream()
//                    .map(EnrollmentStudentResponse::new)
//                    .collect(Collectors.toList());
//        }
    }
}
