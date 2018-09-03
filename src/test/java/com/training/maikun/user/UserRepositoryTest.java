package com.training.maikun.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername() throws Exception {
        User user = userRepository.findByUsername("chen");
        log.info(user.getRoles().get(0).getRoleName());
        log.info(user.getId().toString());

        Assert.assertNotNull(user);
    }

}