package com.keith.security.Config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 必须设置一个encoder才能通过编译，所以这里自定义一个PasswordEncoder
 */

public class CustomEncoder implements PasswordEncoder {

    //SpringSecurity默认加密算法
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //重写加密和匹配
    @Override
    public String encode(CharSequence charSequence) {
        return passwordEncoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return passwordEncoder.matches(charSequence,s);
    }
}
