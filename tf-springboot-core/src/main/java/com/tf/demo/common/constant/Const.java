package com.tf.demo.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 10:25
 * Description:
 */

@Configuration
public class Const {

    public static final String SF_FILE_SEPARATOR = System.getProperty("file.separator");

    public static final String SF_LINE_SEPARATOR = System.getProperty("line.separator");

    public static final String SF_PATH_SEPARATOR = System.getProperty("path.separator");

    public static final String JWT_TOKEN_VALUE = "token value";

    public static final String ALI_ACCESS_KEY = "LTAIoeCnEXWIQ05n";

    public static final String ALI_ACCESS_SECRET = "7Z0wH4c7tYpw1to1FC831hHIcYz5AD";

    public  static final String JWT_TOKEN_PREFIX_KEY = "com:tf:demo:jwt:token:";


    public static String JWT_SECRET;

    public static long JWT_EXPIRE;

    public static String JWT_HEADER;

    public static String PASSWORD_SALT;

    @Value("${jwt.secret}")
    public void setJwtSecret(String jwtSecret) {
        Const.JWT_SECRET = jwtSecret;
    }

    @Value("${jwt.expire}")
    public void setJwtExpire(long jwtExpire) {
        Const.JWT_EXPIRE = jwtExpire;
    }

    @Value("${jwt.header}")
    public void setJwtHeader(String jwtHeader) {
        Const.JWT_HEADER = jwtHeader;
    }

    @Value("${password.salt}")
    public void setPasswordSalt(String passwordSalt) {
        Const.PASSWORD_SALT = passwordSalt;
    }

}