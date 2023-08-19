package com.discordance.discordance.dto.response;

import com.discordance.discordance.domain.Member;
import io.swagger.v3.oas.annotations.media.Schema;

public record MemberUpdateResponse(
        @Schema(description = "회원 정보 수정 성공 여부", example = "true")
        boolean result,
        @Schema(description = "회원 이름", example = "고동민")
        String userNickName,
        @Schema(description = "회원 나이", example = "23")
        String userProfilePicUrl
) {
    public static MemberUpdateResponse of(boolean result, Member member) {
        return new MemberUpdateResponse(result, member.getUserNickname(), member.getUserProfilePicUrl());
    }
}
