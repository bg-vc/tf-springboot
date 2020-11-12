package com.tf.demo.common.exception;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 10:49
 * Description:
 */
public class JwtTokenEmptyException extends RuntimeException {

    public JwtTokenEmptyException() {
    }

    public JwtTokenEmptyException(String message) {
        super(message);
    }

    public JwtTokenEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
