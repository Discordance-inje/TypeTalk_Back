package com.discordance.discordance.domain;

import jakarta.persistence.*;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String value;
    private String title;
    private String text;

    @Column(name = "img_path")
    private String imgPath;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "positive_id")
    private Result positive;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "negative_id")
    private Result negative;


    public Result() {
    }

    public Result(Long id, String value, String title, String text, String imgPath, Result positive, Result negative) {
        this.id = id;
        this.value = value;
        this.title = title;
        this.text = text;
        this.imgPath = imgPath;
        this.positive = positive;
        this.negative = negative;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getImgPath() {
        return imgPath;
    }

    public Result getPositive() {
        return positive;
    }

    public Result getNegative() {
        return negative;
    }
}
