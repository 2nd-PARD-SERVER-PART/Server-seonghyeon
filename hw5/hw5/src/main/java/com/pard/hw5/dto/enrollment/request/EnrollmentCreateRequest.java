package com.pard.hw5.dto.enrollment.request;

import com.pard.hw5.entity.enrollment.Enrollment;
import lombok.Data;

@Data
public class EnrollmentCreateRequest {
    private String lectureName; // 강의 이름이 있어야 할까?
    private Long studentId;
    private Long lectureId;
}
