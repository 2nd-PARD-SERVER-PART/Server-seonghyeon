package com.pard.hw5.dto.enrollment.response;

import com.pard.hw5.dto.lecture.response.LectureInfoResponse;
import com.pard.hw5.entity.enrollment.Enrollment;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
//학생 entity에서 볼 강의 정보 -> 강의 이름, 강의 시간, 강의 장소
//response dto에 객체를 넣어도 돼?
public class EnrollmentStudentResponse {
    private Long id;
    private LectureInfoResponse lecture;

    public EnrollmentStudentResponse(Enrollment enrollment) {
        this.id = enrollment.getId();
        if (enrollment.getLecture() != null) {
            this.lecture = new LectureInfoResponse(enrollment.getLecture());
        }
    }
}
