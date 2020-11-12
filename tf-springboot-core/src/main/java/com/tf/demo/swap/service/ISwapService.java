package com.tf.demo.swap.service;

import com.tf.common.model.Result;
import com.tf.demo.swap.model.TronSwapToken;

import java.util.List;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 11:46
 * Description:
 */
public interface ISwapService {

    /**
     *
     * @return
     */
    Result<List<TronSwapToken>> queryTronSwapTokenList();
}
