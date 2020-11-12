package com.tf.demo.common.exception;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 10:44
 * Description:
 */
public class ServiceNotFoundException extends RuntimeException {

    public ServiceNotFoundException() {}

    public ServiceNotFoundException(String message) {
        super(message);
    }

    public ServiceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
