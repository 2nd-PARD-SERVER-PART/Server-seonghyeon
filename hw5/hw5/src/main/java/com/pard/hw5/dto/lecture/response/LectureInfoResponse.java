package com.pard.hw5.dto.lecture.response;

import com.pard.hw5.entity.lecture.Lecture;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LectureInfoResponse {
    private Long id;
    private String name; // 강의명
    private String room; // 강의실
    private String prof; // 선생님
    private Integer type; // 강의타입(전체, 분반)
    private Integer time; // 시간
    private String book; // 교재

    public LectureInfoResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.name = lecture.getName();
        this.room = lecture.getRoom();
        this.prof = lecture.getProf();
        this.type = lecture.getType();
        this.time = lecture.getTime();
        this.book = lecture.getBook();
    }
}
