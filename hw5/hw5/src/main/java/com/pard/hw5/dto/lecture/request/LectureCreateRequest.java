package com.pard.hw5.dto.lecture.request;

import com.pard.hw5.entity.lecture.Lecture;
import lombok.Data;

@Data
public class LectureCreateRequest {
    private String name; // 강의명
    private String room; // 강의실
    private String prof; // 선생님
    private Integer type; // 강의타입(전체, 분반)
    private Integer time; // 시간
    private String book; // 교재

    public Lecture toEntity() {
        return Lecture.builder()
                .name(name)
                .room(room)
                .prof(prof)
                .type(type)
                .time(time)
                .book(book)
                .build();
    }
}
