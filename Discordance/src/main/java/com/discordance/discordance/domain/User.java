package com.discordance.discordance.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Table(name = "user")
@Entity
public class User {

    @Id
    @NotEmpty
    @Column(name = "_id")
    private String id;

    @NotEmpty
    @Column(name = "user_nickname")
    private String userNickname;

    @NotEmpty
    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_profile_pic_url")
    private String userProfilePicUrl;
}
