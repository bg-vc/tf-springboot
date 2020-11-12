package com.tf.demo.swap.service.impl;

import com.tf.common.enums.ResultCode;
import com.tf.common.model.Result;
import com.tf.demo.swap.dao.TronSwapTokenMapper;
import com.tf.demo.swap.service.ISwapService;
import com.tf.demo.swap.model.TronSwapToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 11:47
 * Description:
 */
@Service
@Slf4j
public class SwapServiceImpl implements ISwapService {
    @Resource
    private TronSwapTokenMapper tronSwapTokenMapper;

    @Override
    public Result<List<TronSwapToken>> queryTronSwapTokenList() {
        Result<List<TronSwapToken>> result = new Result<>();
        try {
            List dataList =  tronSwapTokenMapper.selectAll();
            result.setData(dataList);
            return result;
        } catch (Exception e) {
            log.error("queryTronSwapTokenList error: {}", e.getMessage());
            return result.setResult(ResultCode.INTERNAL_SERVER_ERROR);
        }

    }
}
