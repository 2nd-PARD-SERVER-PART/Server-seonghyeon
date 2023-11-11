package com.pard.hw5.dto.lecture.request;

import lombok.Data;

@Data
public class LectureUpdateRequest {
    private String name; // 강의명
    private String room; // 강의실
    private String prof; // 선생님
    private Integer type; // 강의타입(전체, 분반)
    private Integer time; // 시간
    private String book; // 교재
}
