package com.discordance.discordance.dto.response;

import com.discordance.discordance.domain.Member;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigInteger;

public record MemberInfoResponse(
        @Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b0a-6b1c032f0e4a")
        BigInteger id,

        @Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b0a-6b1c032f0e4a")
        String userNickname,

        @Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b0a-6b1c032f0e4a")
        String userPassword,

        @Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b0a-6b1c032f0e4a")
        String userProfilePicUrl
) {
    public static MemberInfoResponse from(Member member) {
        return new MemberInfoResponse(
                member.getId(),
                member.getUserPassword(),
                member.getUserNickname(),
                member.getUserProfilePicUrl()
        );
    }
}
