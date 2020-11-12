package com.tf.demo.common.exception;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 10:50
 * Description:
 */
public class JwtTokenInvalidException extends RuntimeException {

    public JwtTokenInvalidException() {
    }

    public JwtTokenInvalidException(String message) {
        super(message);
    }

    public JwtTokenInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}