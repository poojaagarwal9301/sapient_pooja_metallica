package com.trade.TradeServices.services;

import com.trade.TradeServices.dto.NotificationDTO;
import com.trade.TradeServices.dto.TradeDTO;
import com.trade.TradeServices.entity.Trade;

public class ConvertToDTO {

	public static TradeDTO getConvertedDto(Trade trade){
		
		TradeDTO tradeDTO = new TradeDTO();
		tradeDTO.setId(trade.getId());
		tradeDTO.setManager(trade.getManager());
		tradeDTO.setCommodity(trade.getCommodity());
		tradeDTO.setCounterParty(trade.getCounterParty());
		tradeDTO.setLocation(trade.getLocation());
		tradeDTO.setPrice(trade.getPrice());
		tradeDTO.setQuantity(trade.getQuantity());
		tradeDTO.setSide(trade.getSide().getSideName());
		tradeDTO.setTradeDate(trade.getTradeDate());
		tradeDTO.setTradeStatus(trade.getTradeStatus().getTradeStatusVal());
		tradeDTO.setCurrency(trade.getCurrency());
		
		return tradeDTO;
	}

	public static NotificationDTO getConvertedNotificationDto(Trade trade) {
		// TODO Auto-generated method stub
		NotificationDTO notificationDTO = new NotificationDTO();
		notificationDTO.setCommodity(trade.getCommodity());
		notificationDTO.setCounterParty(trade.getCounterParty());
		notificationDTO.setLocation(trade.getLocation());
		notificationDTO.setPrice(trade.getPrice());
		notificationDTO.setQuantity(trade.getQuantity());
		notificationDTO.setSide(trade.getSide().getSideName());
		notificationDTO.setTradeDate(trade.getTradeDate());
		notificationDTO.setTradeStatus(trade.getTradeStatus().getTradeStatusVal());
		notificationDTO.setCurrency(trade.getCurrency());
		
		return notificationDTO;
	}
}
