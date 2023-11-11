package com.pard.hw5.dto.enrollment.response;

import com.pard.hw5.dto.lecture.response.LectureInfoResponse;
import com.pard.hw5.entity.enrollment.Enrollment;
import com.pard.hw5.entity.lecture.Lecture;
import com.pard.hw5.entity.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
//학생 entity에서 볼 강의 정보 -> 강의 이름, 강의 시간, 강의 장소
public class EnrollmentStudentResponse {
    private List<Lecture> lectures;

}
