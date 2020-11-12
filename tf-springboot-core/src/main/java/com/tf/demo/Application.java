package com.tf.demo;

import com.tf.demo.common.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 10:13
 * Description:
 */
@SpringBootApplication
@EnableScheduling
@Import(value = {SpringUtil.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
