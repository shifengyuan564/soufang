package com.imooc.soufang.entity;

import com.imooc.soufang.AppTests;
import com.imooc.soufang.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author: yuan
 * Date: 2018/12/20
 * Time: 16:44
 */
public class UserRepositoryTest extends AppTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindOne(){

        Optional<User> optional = userRepository.findById(1L);
        if (optional.isPresent()) {
            User user = optional.get();
            System.out.println(user.getName());
            Assert.assertEquals("waliwali", user.getName());
        }

    }
}
