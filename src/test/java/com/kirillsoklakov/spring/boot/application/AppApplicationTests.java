package com.kirillsoklakov.spring.boot.application;

import com.kirillsoklakov.spring.boot.application.model.User;
import com.kirillsoklakov.spring.boot.application.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindUserByLogin(){
        String login = "admin";

        User user = userRepository.findUserByLogin(login);

        assertThat(user).isNotNull();
    }
}
