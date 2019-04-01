package com.xmall.hi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BPwdEncoderUtil {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static boolean matches( CharSequence rawPasswrod, String encodedPassword ){
        return passwordEncoder.matches(rawPasswrod, encodedPassword);
    }
}
