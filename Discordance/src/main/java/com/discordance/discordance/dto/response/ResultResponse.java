package com.discordance.discordance.dto.response;


import com.discordance.discordance.domain.Result;
import com.discordance.discordance.vo.ResultVO;

public class ResultResponse {

    private Long id;

    private String value;
    private String title;
    private String text;

    private String imgPath;

    private ResultVO positive;
    private ResultVO negative;

    public ResultResponse() {
    }

    public ResultResponse(Result result) {
        this.id = result.getId();
        this.value = result.getValue();
        this.title = result.getTitle();
        this.text = result.getText();
        this.imgPath = result.getImgPath();
        Result positive = result.getPositive();
        this.positive = new ResultVO(positive);
        Result negative = result.getNegative();
        this.negative = new ResultVO(negative);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public ResultVO getPositive() {
        return positive;
    }

    public void setPositive(ResultVO positive) {
        this.positive = positive;
    }

    public ResultVO getNegative() {
        return negative;
    }

    public void setNegative(ResultVO negative) {
        this.negative = negative;
    }


}
