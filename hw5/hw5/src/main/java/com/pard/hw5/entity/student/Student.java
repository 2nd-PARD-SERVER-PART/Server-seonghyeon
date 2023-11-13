package com.pard.hw5.entity.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pard.hw5.entity.enrollment.Enrollment;
import com.pard.hw5.entity.lecture.Lecture;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 값 증가
    private Long id;
    private String name; // 학생 이름
    private Integer gender; // 성별
    private Integer grade; // 학년
    private String birth; // 생일
    private String phoneNumber; // 전화번호
    /*
    OneToMnay: 한개의 Student 엔티티가 여러개의 Enrollment 엔티티를 가질 수 있음
    mappedBy: Enrollment 엔티티에서 student라는 필드로 Student 엔티티와 연결됨
    cascade: One(Student)의 내용이 변경 될 때 Many(Enrollment)에 어떻게 영향을 줄 것인가?
    CascadeType.ALL: Student 엔티티의 내용이 변경될 때 Enrollment 에도 Student에 관한 내용이 모두 변경됨
    CascadeType.PERSIST: Student 엔티티의 내용이 변경될 때
    */
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Enrollment> enrollments = new ArrayList<>(); // 수강 과목
//    private boolean isDrivingCar; // 학원차 탑승 여부
//    private Integer carNum; // 학원차 호수
//    private String hopeSchool; // 희망 학교
//    private String currentSchool; // 현재 학교
//    private Integer wordExam; // 단어 점수
//-----------------------------------------------------
//    private boolean isHwSubmit;
//    private boolean isBookPaySubmit;
//    private boolean isClassPaySubmit;

    // builder -> 생성자 순서 상관 X
    @Builder
    public Student(String name, Integer gender, Integer grade, String birth, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
    }

    public void update(String name, Integer gender, Integer grade, String birth, String phoneNumber) {
        if (name != null) {
            this.name = name;
        }
        if (gender != -1) {
            this.gender = gender;
        }
        if (grade != -1) {
            this.grade = grade;
        }
        if (birth != null) {
            this.birth = birth;
        }
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        }
    }


}
