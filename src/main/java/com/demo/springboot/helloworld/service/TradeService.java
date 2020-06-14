package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Trade;

public interface TradeService {
    public Trade  insert(Trade trade);
    public Trade updateTradeState(Trade trade);

    public int insertInitial(Trade trade);
}
