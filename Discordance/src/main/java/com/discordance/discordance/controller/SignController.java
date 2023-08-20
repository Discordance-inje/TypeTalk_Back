package com.discordance.discordance.controller;

import com.discordance.discordance.dto.ApiResponse;
import com.discordance.discordance.dto.request.SignInRequest;
import com.discordance.discordance.service.SignService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Tag(name = "회원 가입 및 로그인")
@RequiredArgsConstructor
@RestController
@RequestMapping
public class SignController {
    private final SignService signService;

    @Operation(summary = "회원 가입")
    @PostMapping("/sign-up")
    public ApiResponse signUp(@RequestParam String account, @RequestParam String userPassword, @RequestParam String userNickName,
                              @Parameter(description = "프로필 사진", required = true, content = @Content(mediaType = "multipart/form-data")) MultipartFile profilePicFile) throws IOException{
            return ApiResponse.success(signService.registerMember(account, userPassword, userNickName, profilePicFile));
    }

    @Operation(summary = "로그인")
    @PostMapping("/sign-in")
    public ApiResponse signIn(@RequestBody SignInRequest request) {
        return ApiResponse.success(signService.signIn(request));
    }

    @PostMapping("/test")
    public void getImage( MultipartFile test){
    }
}
