package com.discordance.discordance.domain;

import com.discordance.discordance.common.MemberType;
import com.discordance.discordance.dto.request.MemberUpdateRequest;
import com.discordance.discordance.dto.request.SignUpRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;

@Getter
@Table(name = "member")
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "_id")
    private BigInteger id;

    @Column(nullable = false, unique = true)
    private String account;

    @NotEmpty
    @Column(name = "user_nickname")
    private String userNickname;

    @NotEmpty
    @Column(name = "user_password")
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    @Column(name = "user_profile_pic_url")
    private String userProfilePicUrl;

    public static Member from(String account, PasswordEncoder encoder, String userPassword, String userNickname, String userProfilePicUrl) {
        return Member.builder()
                .account(account)
                .userPassword(encoder.encode(userPassword))
                .userNickname(userNickname)
                .userProfilePicUrl(userProfilePicUrl)
                .type(MemberType.USER)
                .build();
    }





    public void update(MemberUpdateRequest newMember, PasswordEncoder encoder) {
        this.userPassword = newMember.newPassword() == null || newMember.newPassword().isBlank()
                ? this.userPassword : encoder.encode(newMember.newPassword());
        this.userNickname = newMember.userNickName();
        this.userProfilePicUrl = newMember.userProfilePicUrl();
    }
}
