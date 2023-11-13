package com.pard.hw5.entity.enrollment;

import com.pard.hw5.entity.lecture.Lecture;
import com.pard.hw5.entity.student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /*
    ManyToOne: 여러개의 Enrollment 엔티티가 하나의 Student 엔티티에 속함
    fetch = FetchType.LAZY: 학생정보를 실제로 사용할 때 DB에서 데이터를 들고옴
    fetch = FetchTYpe.EAGER: 학생정보를 바로 로딩함
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
