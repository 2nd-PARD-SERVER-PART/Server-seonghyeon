package com.pard.hw5.service.lecture;

import com.pard.hw5.dto.lecture.request.LectureCreateRequest;
import com.pard.hw5.dto.lecture.request.LectureUpdateRequest;
import com.pard.hw5.entity.lecture.Lecture;
import com.pard.hw5.repository.lecture.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    public Lecture addLecture(LectureCreateRequest request) {
        return lectureRepository.save(request.toEntity());
    }

    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }

    public Lecture findById(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("강의가 존재하지 않습니다"));
    }

    public Lecture updateLecture(Long lectureId, LectureUpdateRequest request) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("강의가 존재하지 않습니다"));

        lecture.update(request.getName(), request.getRoom(), request.getProf(), request.getType(), request.getTime(), request.getBook());

        return lectureRepository.save(lecture);
    }

    public void deleteLecture(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }
}
