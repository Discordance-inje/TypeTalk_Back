package com.discordance.discordance.controller;


import com.discordance.discordance.domain.Question;
import com.discordance.discordance.domain.Result;
import com.discordance.discordance.dto.response.RecordResponse;
import com.discordance.discordance.dto.request.ResultRequest;
import com.discordance.discordance.dto.response.ResultResponse;
import com.discordance.discordance.repository.QuestionRepository;
import com.discordance.discordance.repository.RecordRepository;
import com.discordance.discordance.repository.ResultRepository;
import com.discordance.discordance.service.RecordService;
import com.discordance.discordance.service.ResultService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "MBTI 검사")
@RestController
@RequestMapping("/mbti")
public class MbtiController {

    private final ResultRepository resultRepository;
    private final RecordRepository recordRepository;
    private final QuestionRepository questionRepository;
    private final RecordService recordService;
    private final ResultService resultService;


    public MbtiController(ResultRepository resultRepository, RecordRepository recordRepository, QuestionRepository questionRepository, RecordService recordService, ResultService resultService) {
        this.resultRepository = resultRepository;
        this.recordRepository = recordRepository;
        this.questionRepository = questionRepository;
        this.recordService = recordService;
        this.resultService = resultService;
    }

    @GetMapping("question")
    public List<Question> getQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions;
    }


    @GetMapping("{value}")
    public ResultResponse getResult(@PathVariable String value) {
        Result result = resultRepository.findByValue(value).orElse(null);
        if (result == null)
            return null;

        ResultResponse resultResponse = new ResultResponse(result);
        return resultResponse;
    }

    @PostMapping("result")
    public ResultResponse result(@Valid @RequestBody ResultRequest request) {
        Result result = resultService.result(request);
        ResultResponse resultResponse = new ResultResponse(result);
        return resultResponse;
    }

    @GetMapping("record")
    public RecordResponse getRecords() {
        RecordResponse response = recordService.getRecords();
        return response;
    }

}
