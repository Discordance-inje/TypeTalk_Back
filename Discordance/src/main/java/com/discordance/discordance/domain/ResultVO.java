package com.discordance.discordance.domain;

public class ResultVO {

    private Long id;

    private String value;
    private String title;
    private String text;

    private String imgPath;

    public ResultVO(Long id, String value, String title, String text, String imgPath) {
        this.id = id;
        this.value = value;
        this.title = title;
        this.text = text;
        this.imgPath = imgPath;
    }

    public ResultVO() {
    }

    public ResultVO(Result result) {
        this.id = result.getId();
        this.value = result.getValue();
        this.title = result.getTitle();
        this.text = result.getText();
        this.imgPath = result.getImgPath();
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
}
