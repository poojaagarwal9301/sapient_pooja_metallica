package com.trade.TradeServices.services;

import org.springframework.stereotype.Component;

import com.trade.TradeServices.dto.TradeDTO;
import com.trade.TradeServices.entity.Trade;

@Component
public interface TradeService {

	void persistTrade(Trade trade) throws Exception ;
	 
	TradeDTO findTradeById(int id);
 
	TradeDTO updateTrade(Trade trade);
 
    void deleteTrade(Trade trade);
}
