package com.pard.hw5.controller.enrollment;

import com.pard.hw5.dto.enrollment.request.EnrollmentCreateRequest;
import com.pard.hw5.dto.enrollment.response.EnrollmentStudentResponse;
import com.pard.hw5.entity.enrollment.Enrollment;
import com.pard.hw5.service.enrollment.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping("/add")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody EnrollmentCreateRequest request) {
        Enrollment enrollment = enrollmentService.addEnrollment(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(enrollment);
    }

    @GetMapping("/find/{studentId}")
    public ResponseEntity<EnrollmentStudentResponse> findLectures(@PathVariable Long studentId) {

        return ResponseEntity.ok().body(enrollmentService.findStudent(studentId));
    }
}
