package com.tf.test.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TronSwapToken {
    private Integer id;

    private String lpTokenAddress;

    private String swapTokenAddress;

    private String swapTokenName;

    private Byte swapTokenType;

    private Byte swapTokenPrecision;

    private String swapPicUrl;

    private String swapPairName;

    private String swapPairAddress;

    private String baseTokenAddress;

    private String baseTokenName;

    private Byte baseTokenType;

    private Byte baseTokenPrecision;

    private String basePicUrl;

    private BigDecimal swapTokenAmount;

    private BigDecimal baseTokenAmount;

    private BigDecimal totalLiquidity;

    private BigDecimal swapTokenPrice1;

    private BigDecimal swapTokenPrice2;

    private BigDecimal baseTokenPrice1;

    private BigDecimal baseTokenPrice2;

    private BigDecimal volume24h;

    private Long transaction24h;

    private Byte status;

    private Long createTime;

    private Date updateTime;

}