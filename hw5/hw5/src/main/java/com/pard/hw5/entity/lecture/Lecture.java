package com.pard.hw5.entity.lecture;

import com.pard.hw5.entity.enrollment.Enrollment;
import com.pard.hw5.entity.student.Student;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 강의명
    private String room; // 강의실
    private String prof; // 선생님
    private Integer type; // 강의타입(전체, 분반)
    private Integer time; // 시간
    private String book; // 교재
    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>(); // 수강학생

    @Builder
    public Lecture(String name, String room, String prof, Integer type, Integer time, String book) {
        this.name = name;
        this.room = room;
        this.prof = prof;
        this.type = type;
        this.time = time;
        this.book = book;
    }

    public void update(String name, String room, String prof, Integer type, Integer time, String book) {
        if (name != null) {
            this.name = name;
        }
        if (room != null) {
            this.room = room;
        }
        if (prof != null) {
            this.prof = prof;
        }
        if (type != -1) {
            this.type = type;
        }
        if (time != -1) {
            this.time = time;
        }
        if (book != null) {
            this.book = book;
        }
    }
}
