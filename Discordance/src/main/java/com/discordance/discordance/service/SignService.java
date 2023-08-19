package com.discordance.discordance.service;

import com.discordance.discordance.domain.Member;
import com.discordance.discordance.dto.request.SignInRequest;
import com.discordance.discordance.dto.request.SignUpRequest;
import com.discordance.discordance.dto.response.SignInResponse;
import com.discordance.discordance.dto.response.SignUpResponse;
import com.discordance.discordance.repository.MemberRepository;
import com.discordance.discordance.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class SignService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public SignUpResponse registerMember(String account, String userPassword, String userNickName, MultipartFile profilePicFile) throws IOException {
        String profilePicPath = "/images/" + profilePicFile.getOriginalFilename();
        profilePicFile.transferTo(new File(profilePicPath));
        Member member = memberRepository.save(Member.from(account, encoder, userPassword, userNickName, profilePicPath));
        try {
            memberRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
        return SignUpResponse.from(member);
    }



    @Transactional(readOnly = true)
    public SignInResponse signIn(SignInRequest request) {
        Member member = memberRepository.findByAccount(request.account())
                .filter(it -> encoder.matches(request.userPassword(), it.getUserPassword()))
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
        String token = tokenProvider.createToken(String.format("%s:%s", member.getId(), member.getType()));
        return new SignInResponse(member.getUserNickname(), member.getType(), token);
    }
}
