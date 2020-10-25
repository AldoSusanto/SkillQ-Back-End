package com.skillq.main.controller;

import com.skillq.main.model.entity.Chapter;
import com.skillq.main.model.request.GetChapterRequest;
import com.skillq.main.repository.ChapterRepository;
import com.skillq.main.util.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/chapters")
public class ChapterController {

    private ChapterRepository chapterRepository;

    public ChapterController(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @PostMapping("/by/request")
    private Chapter getChapterByCourseIdAndChapterNumber(@Valid @RequestBody GetChapterRequest request){
        return chapterRepository.findByCourseIdAndChapterNumber(request.getCourseId(), request.getChapterNumber())
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "00006", "Chapter with courseId: " + request.getCourseId() + " and chapter number: " + request.getChapterNumber() + " doesn't exist"));
    }
}
