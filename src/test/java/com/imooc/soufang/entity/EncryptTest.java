package com.imooc.soufang.entity;

import com.imooc.soufang.AppTests;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: yuan
 * @Date: 2018/12/24 8:37
 * @Description:
 */
public class EncryptTest extends AppTests {

    @Test
    public void testEncode(){

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePasswd = encoder.encode("123456");
        System.out.println(encodePasswd);

    }

}
