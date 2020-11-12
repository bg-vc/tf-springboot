package com.tf.demo.web.api.swap;

import com.tf.common.model.Result;
import com.tf.demo.swap.model.TronSwapToken;
import com.tf.demo.swap.service.ISwapService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 11:15
 * Description:
 */
@RestController
@RequestMapping("demo/api/swap/")
public class SwapController {

    @Resource
    private ISwapService swapService;

    @RequestMapping(value = "queryTronSwapTokens", method = RequestMethod.GET)
    public Result<List<TronSwapToken>> queryTronSwapTokenList() {
        Result<List<TronSwapToken>> result = swapService.queryTronSwapTokenList();
        return result;
    }

}