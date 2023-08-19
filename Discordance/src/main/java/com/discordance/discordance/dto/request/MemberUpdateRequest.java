package com.discordance.discordance.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record MemberUpdateRequest(
        @Schema(description = "회원 비밀번호", example = "1234")
        String userPassword,
        @Schema(description = "회원 새 비밀번호", example = "1234")
        String newPassword,
        @Schema(description = "회원 이름", example = "고동민")
        String userNickName,
        @Schema(description = "프로필 사진 링크", example = "/images")
        String userProfilePicUrl
) {
}
