package com.knuaf.chickenstock.domain.member.controller;

import com.knuaf.chickenstock.domain.member.dto.ResponseDto;
import com.knuaf.chickenstock.domain.member.dto.SignInDto;
import com.knuaf.chickenstock.domain.member.dto.SignUpDto;
import com.knuaf.chickenstock.domain.member.service.MemberService;
import com.knuaf.chickenstock.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpDto signUpDto) throws Exception {

        try {
            memberService.signup(signUpDto);
            return ResponseEntity.ok(ApiResponse.success("회원가입 성공!", null));
        } catch (Exception e) {
            // 에러가 발생하면 서버가 터지는 게 아니라, 에러 메시지를 담아서 보냅니다.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> login(@RequestBody SignInDto signInDto) {
        try {
            ResponseDto result = memberService.login(signInDto);
            return ResponseEntity.ok(ApiResponse.success("로그인 성공!", result.getData()));
        } catch (IllegalArgumentException e) {
            // 아이디/비밀번호가 틀렸을 때 예쁘게 답장하기
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        } catch (Exception e) {
            // 기타 서버 에러
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("서버 내부 오류가 발생했습니다."));
        }
    }
}
