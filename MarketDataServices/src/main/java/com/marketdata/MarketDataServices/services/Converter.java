package com.marketdata.MarketDataServices.services;

import com.marketdata.MarketDataServices.dto.NotificationDTO;
import com.marketdata.MarketDataServices.entity.Commodity;

public class Converter {

	public static NotificationDTO convertToDTO(Commodity commodity){
		
		NotificationDTO dto = new NotificationDTO();
		dto.setCode(commodity.getCode());
		dto.setDescription(commodity.getDescription());
		dto.setPrice(commodity.getPrice());
		
		return dto;
	}
}
