package com.pard.hw5.repository.enrollment;

import com.pard.hw5.entity.enrollment.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
