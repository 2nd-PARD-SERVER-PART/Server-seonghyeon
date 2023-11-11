package com.pard.hw5.controller.student;

import com.pard.hw5.dto.student.request.StudentCreateRequest;
import com.pard.hw5.dto.student.request.StudentUpdateRequest;
import com.pard.hw5.dto.student.response.StudentInfoResponse;
import com.pard.hw5.entity.student.Student;
import com.pard.hw5.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    //왜 ResponseEntity 로 안 묶어줘?
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody StudentCreateRequest request) {
        Student student = studentService.addStudent(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(student);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<StudentInfoResponse>> findAllStudents() {
        List<StudentInfoResponse> students = studentService.findAll()
                .stream()
                .map(StudentInfoResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(students);
    }

    @GetMapping("/find/{studentId}")
    public ResponseEntity<StudentInfoResponse> findStudent(@PathVariable Long studentId) {
        Student student = studentService.findById(studentId);

        return ResponseEntity.ok()
                .body(new StudentInfoResponse(student));
    }

    @PatchMapping("/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody StudentUpdateRequest request) {
        Student updateStudent = studentService.updateStudent(studentId, request);

        return ResponseEntity.ok()
                .body(updateStudent);

    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);

        return ResponseEntity.noContent()
                .build();
    }
}
