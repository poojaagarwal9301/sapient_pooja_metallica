package com.trade.TradeServices.dao;

import org.springframework.stereotype.Component;

import com.trade.TradeServices.entity.Trade;

@Component
public interface TradeDao {

	void persistTrade(Trade trade);
    
	Trade findTradeById(int id);
     
	Trade updateTrade(Trade trade);
     
    void deleteTrade(Trade trade);
}
