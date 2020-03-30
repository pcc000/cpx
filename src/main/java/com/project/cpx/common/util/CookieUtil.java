package com.project.cpx.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/30 12:08
 * @Description:
 */
public class CookieUtil {

    public CookieUtil() {
    }

    public static String getCookieValue(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            return null;
        } else {
            Cookie[] var3 = cookies;
            int var4 = cookies.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Cookie cookie = var3[var5];
                if (key.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }

            return null;
        }
    }
}
