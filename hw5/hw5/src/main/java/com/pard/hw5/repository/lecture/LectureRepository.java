package com.pard.hw5.repository.lecture;

import com.pard.hw5.entity.lecture.Lecture;
import com.pard.hw5.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Optional<Lecture> findByName(String name);

}
