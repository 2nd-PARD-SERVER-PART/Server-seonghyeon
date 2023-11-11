package com.pard.hw5.service.enrollment;

import com.pard.hw5.dto.enrollment.request.EnrollmentCreateRequest;
import com.pard.hw5.entity.enrollment.Enrollment;
import com.pard.hw5.entity.lecture.Lecture;
import com.pard.hw5.entity.student.Student;
import com.pard.hw5.repository.enrollment.EnrollmentRepository;
import com.pard.hw5.repository.lecture.LectureRepository;
import com.pard.hw5.repository.student.StudentRepository;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class EnrollmentService {
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(StudentRepository studentRepository, LectureRepository lectureRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.lectureRepository = lectureRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Transactional
    public Enrollment addEnrollment(EnrollmentCreateRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("학생을 찾을 수 없습니다."));
        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("강좌를 찾을 수 없습니다."));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setLecture(lecture);
        enrollment.setLectureName(request.getLectureName());

        return enrollmentRepository.save(enrollment);
    }
}
