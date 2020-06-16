package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Trade;
import com.demo.springboot.helloworld.common.domain.TradeExample;
import com.demo.springboot.helloworld.mapper.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeMapper tradeMapper;

    @Override
    public Trade insert(Trade trade) {
        tradeMapper.insert(trade);
        return trade;
    }

    @Override
    public Trade updateTradeState(Trade trade)
    {
        tradeMapper.updateByPrimaryKeySelective(trade);
        return trade;
    }// 用于在收到支付宝返回信息后更新订单状态

    @Override
    public int insertInitial(Trade trade)
    {
        return tradeMapper.insertInitial(trade);
        //返回的是插入的行数
        //不是自增id
    }
}
