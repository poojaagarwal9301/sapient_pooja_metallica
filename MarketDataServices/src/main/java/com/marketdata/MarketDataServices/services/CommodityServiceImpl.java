package com.marketdata.MarketDataServices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marketdata.MarketDataServices.dao.CommodityDao;
import com.marketdata.MarketDataServices.entity.Commodity;
import com.marketdata.MarketDataServices.rabbit.QueueProducer;

@Component
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	private QueueProducer queueProducer;

	@Override
	public void persistCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		commodityDao.persistCommodity(commodity);
		try {
			queueProducer.produce(Converter.convertToDTO(commodity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Commodity findCommodityById(int id) {
		// TODO Auto-generated method stub
		return commodityDao.findCommodityById(id);
	}

	@Override
	public Commodity updateCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return commodityDao.updateCommodity(commodity);
	}

	@Override
	public void deleteCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		commodityDao.deleteCommodity(commodity);
	}

	@Override
	public List<Commodity> getAll() {
		// TODO Auto-generated method stub
		return commodityDao.getAll();
	}}
