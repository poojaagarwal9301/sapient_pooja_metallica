package com.trade.TradeServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trade.TradeServices.dto.TradeDTO;
import com.trade.TradeServices.dao.TradeDao;
import com.trade.TradeServices.entity.Trade;
import com.trade.TradeServices.rabbit.QueueProducer;

@Component
public class TradeServiceImpl implements TradeService {
	
	@Autowired
	private TradeDao tradeDaoService;
	
	@Autowired
	private QueueProducer queueProducer;

	@Override
	public void persistTrade(Trade trade) throws Exception {
		// TODO Auto-generated method stub
		tradeDaoService.persistTrade(trade);
		queueProducer.produce(ConvertToDTO.getConvertedNotificationDto(trade));
	}

	@Override
	public TradeDTO findTradeById(int id) {
		// TODO Auto-generated method stub
		Trade trade = tradeDaoService.findTradeById(id);
		if(trade!=null)
			return ConvertToDTO.getConvertedDto(trade);
		
		return null;
	}

	@Override
	public TradeDTO updateTrade(Trade trade) {
		// TODO Auto-generated method stub
		Trade tr = tradeDaoService.updateTrade(trade);
		if(tr!=null)
			return ConvertToDTO.getConvertedDto(tr);
		
		return null;
	}

	@Override
	public void deleteTrade(Trade trade) {
		// TODO Auto-generated method stub
		tradeDaoService.deleteTrade(trade);
	}
	
	
}
