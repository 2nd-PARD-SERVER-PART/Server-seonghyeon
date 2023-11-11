package com.pard.hw5.dto.enrollment.request;

import lombok.Data;

@Data
public class EnrollmentUpdateRequest {
    private Long studentId;
    private Long lectureId;
}
