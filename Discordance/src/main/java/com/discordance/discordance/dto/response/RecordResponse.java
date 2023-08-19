package com.discordance.discordance.dto.response;

import com.discordance.discordance.vo.RecordVO;

import java.util.List;

public class RecordResponse {

    private int count;
    private List<RecordVO> records;

    public RecordResponse(List<RecordVO> records) {
        this.count = records.size();
        this.records = records;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<RecordVO> getRecords() {
        return records;
    }

    public void setRecords(List<RecordVO> records) {
        this.records = records;
    }

}
