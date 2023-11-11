package com.pard.hw5.service.student;

import com.pard.hw5.dto.student.request.StudentCreateRequest;
import com.pard.hw5.dto.student.request.StudentUpdateRequest;
import com.pard.hw5.entity.student.Student;
import com.pard.hw5.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 뭐였지,,,
public class StudentService {
    private final StudentRepository studentRepository;

    public Student addStudent(StudentCreateRequest request) {
        return studentRepository.save(request.toEntity());
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
    }

    //jpa 메소드에 update가 없기 때문에 user 객체 이용해 내용 업데이트 후 save 사용
    public Student updateStudent(Long userId, StudentUpdateRequest request) {
        Student student = studentRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다"));

        student.update(request.getName(), request.getGender(), request.getGrade(), request.getBirth(), request.getPhoneNumber());

        return studentRepository.save(student);
    }

    public void deleteStudent(Long userId) {
        studentRepository.deleteById(userId);
    }

}
