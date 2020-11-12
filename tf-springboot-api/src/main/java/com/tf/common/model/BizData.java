package com.tf.common.model;

import lombok.Data;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 09:58
 * Description:
 */
@Data
public class BizData<T> {

    private Integer total;

    private T rows;

}
