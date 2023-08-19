package com.discordance.discordance.dto.response;

import com.discordance.discordance.common.MemberType;
import io.swagger.v3.oas.annotations.media.Schema;

public record SignInResponse(
        @Schema(description = "회원 이름", example = "홍길동")
        String userNickName,
        @Schema(description = "회원 유형", example = "USER")
        MemberType type,
        String token
) {
}
