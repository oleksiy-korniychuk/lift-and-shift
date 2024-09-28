package com.oleksiyk.lift_and_shift;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;

public class Utilities {
    public static Cookie getTokenCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies == null || cookies.length == 0) {
            return null;
        }
        return Arrays.stream(request.getCookies())
                .filter(cookie -> "las_token".equals(cookie.getName()))
                .findFirst()
                .orElse(null);
    }
}
