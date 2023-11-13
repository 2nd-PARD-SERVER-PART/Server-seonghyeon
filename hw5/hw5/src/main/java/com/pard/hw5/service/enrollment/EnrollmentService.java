package com.pard.hw5.service.enrollment;

import com.pard.hw5.dto.enrollment.request.EnrollmentCreateRequest;
import com.pard.hw5.dto.enrollment.response.EnrollmentResponse;
import com.pard.hw5.dto.enrollment.response.EnrollmentStudentResponse;
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

import java.util.ArrayList;
import java.util.List;

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

    //강의 듣는 학생 추가
    @Transactional
    public Enrollment addEnrollment(EnrollmentCreateRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("학생을 찾을 수 없습니다."));
        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("강좌를 찾을 수 없습니다."));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setLecture(lecture);
//        enrollment.setLectureName(request.getLectureName());

        return enrollmentRepository.save(enrollment);
    }

    @Transactional
    public EnrollmentStudentResponse findStudent(Long student_id) {
        List<Enrollment> enrollments=enrollmentRepository.findByStudentId(student_id);
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < enrollments.size(); i++) {
            lectures.add(enrollments.get(i).getLecture());
        }
        EnrollmentStudentResponse response = new EnrollmentStudentResponse();
        response.setLectures(lectures);
        return response;
    }
}
