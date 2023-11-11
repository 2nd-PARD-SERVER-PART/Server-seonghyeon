package com.pard.hw5.dto.enrollment.request;

import com.pard.hw5.entity.enrollment.Enrollment;
import lombok.Data;

@Data
public class EnrollmentCreateRequest {
    private Long studentId;
    private Long lectureId;
    private String lectureName;
}
