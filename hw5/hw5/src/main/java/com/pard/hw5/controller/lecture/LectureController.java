package com.pard.hw5.controller.lecture;

import com.pard.hw5.dto.lecture.request.LectureCreateRequest;
import com.pard.hw5.dto.lecture.request.LectureUpdateRequest;
import com.pard.hw5.dto.lecture.response.LectureInfoResponse;
import com.pard.hw5.dto.student.response.StudentInfoResponse;
import com.pard.hw5.entity.lecture.Lecture;
import com.pard.hw5.service.lecture.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lecture")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @PostMapping("/add")
    public ResponseEntity<Lecture> addLecture(@RequestBody LectureCreateRequest request) {
        Lecture addLecture = lectureService.addLecture(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addLecture);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<LectureInfoResponse>> findAllLecture() {
        List<LectureInfoResponse> lectures = lectureService.findAll()
                .stream()
                .map(LectureInfoResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(lectures);
    }

    @GetMapping("/find/{lectureId}")
    public ResponseEntity<LectureInfoResponse> findOneLecture(@PathVariable Long lectureId) {
        Lecture lecture = lectureService.findById(lectureId);

        return ResponseEntity.ok()
                .body(new LectureInfoResponse(lecture));
    }

    @PatchMapping("/update/{lectureId}")
    public ResponseEntity<Lecture> updateLecture(@PathVariable Long lectureId, @RequestBody LectureUpdateRequest request) {
        Lecture lecture = lectureService.updateLecture(lectureId, request);

        return ResponseEntity.ok()
                .body(lecture);
    }

    @DeleteMapping("/delete/{lectureId}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long lectureId) {
        lectureService.deleteLecture(lectureId);

        return ResponseEntity.noContent()
                .build();
    }
}
