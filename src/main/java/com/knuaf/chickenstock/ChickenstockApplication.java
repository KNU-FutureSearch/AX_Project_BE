package com.knuaf.chickenstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling; // 추가

@SpringBootApplication
@EnableScheduling // 💡 스케줄링 기능을 여기로 가져옵니다.
public class ChickenstockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChickenstockApplication.class, args);
	}
}