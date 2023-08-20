package com.discordance.discordance.service;

import com.discordance.discordance.domain.Record;
import com.discordance.discordance.domain.Result;
import com.discordance.discordance.dto.request.ResultRequest;
import com.discordance.discordance.repository.RecordRepository;
import com.discordance.discordance.repository.ResultRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final RecordRepository recordRepository;

    public ResultService(ResultRepository resultRepository, RecordRepository recordRepository) {
        this.resultRepository = resultRepository;
        this.recordRepository = recordRepository;
    }

    @Transactional
    public Result result(ResultRequest request){
        String value = request.getValue();
        Result result = resultRepository.findByValue(value).orElse(null);
        if (result == null){
            return null;
        }
        return record(result);
    }


    public Result record(Result result){
        Record record = new Record(result);
        recordRepository.record(record);
        return result;
    }


}
