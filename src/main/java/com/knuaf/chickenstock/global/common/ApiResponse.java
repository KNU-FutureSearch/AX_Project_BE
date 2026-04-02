package com.knuaf.chickenstock.global.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;  // 요청 성공 여부 (true/false)
    private String message;   // 프론트엔드에 띄워줄 메시지
    private T data;           // 실제 전달할 데이터 (객체, 리스트, 토큰 등)

    // 성공 시 호출할 메서드
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }

    // 실패 시 호출할 메서드
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, null);
    }
}