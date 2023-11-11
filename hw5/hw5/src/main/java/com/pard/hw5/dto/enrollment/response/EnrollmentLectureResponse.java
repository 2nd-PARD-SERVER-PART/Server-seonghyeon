package com.pard.hw5.dto.enrollment.response;

import com.pard.hw5.entity.enrollment.Enrollment;
import com.pard.hw5.entity.student.Student;

public class EnrollmentLectureResponse {
    private Long id;
    private Student student;

    public EnrollmentLectureResponse(Enrollment enrollment, Student student) {
        this.id = enrollment.getId();
        this.student = student;
    }
}
