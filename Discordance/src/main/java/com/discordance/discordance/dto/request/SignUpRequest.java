package com.discordance.discordance.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

public record SignUpRequest(
        @Schema(description = "회원 아이디", example = "example1234")
        String account,
        @Schema(description = "회원 비밀번호", example = "1234")
        String userPassword,
        @Schema(description = "회원 이름", example = "홍길동")
        String userNickname,
        MultipartFile userProfilePic
) {
}
