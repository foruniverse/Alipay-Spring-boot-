package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Trade;
import com.demo.springboot.helloworld.common.domain.TradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeMapper {
    long countByExample(TradeExample example);

    int deleteByExample(TradeExample example);

    int deleteByPrimaryKey(Integer outTradeNo);

    int insert(Trade record);

    //插入初始订单,这时的订单状态位"0",即等待用户支付(用户已点击支付按钮,但还未支付)
    int insertInitial(Trade record);


    int insertSelective(Trade record);

    List<Trade> selectByExample(TradeExample example);

    Trade selectByPrimaryKey(Integer outTradeNo);

    int updateByExampleSelective(@Param("record") Trade record, @Param("example") TradeExample example);

    int updateByExample(@Param("record") Trade record, @Param("example") TradeExample example);

    int updateByPrimaryKeySelective(Trade record);

    int updateByPrimaryKey(Trade record);




}