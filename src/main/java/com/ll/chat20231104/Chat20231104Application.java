package com.ll.chat20231104;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // @CreatedDate, @LastModifiedDate를 사용하기 위해 필요
public class Chat20231104Application {

    public static void main(String[] args) {
        SpringApplication.run(Chat20231104Application.class, args);
    }

}
