package com.marketdata.MarketDataServices.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.marketdata.MarketDataServices.entity.Commodity;

@Component
public interface CommodityService {

	void persistCommodity(Commodity commodity);
	
	List<Commodity> getAll();
	 
	Commodity findCommodityById(int id);
 
	Commodity updateCommodity(Commodity commodity);
 
    void deleteCommodity(Commodity commodity);
}
