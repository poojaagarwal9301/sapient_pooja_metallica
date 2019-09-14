package com.marketdata.MarketDataServices.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.marketdata.MarketDataServices.entity.Commodity;



@Component
public interface CommodityDao {

	void persistCommodity(Commodity trade);
    
	Commodity findCommodityById(int id);
     
	Commodity updateCommodity(Commodity trade);
     
    void deleteCommodity(Commodity trade);
    
    List<Commodity> getAll();
}
