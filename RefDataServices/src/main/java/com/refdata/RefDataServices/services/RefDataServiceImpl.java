package com.refdata.RefDataServices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.refdata.RefDataServices.dao.RefDataDao;
import com.refdata.RefDataServices.entity.Commodity;
import com.refdata.RefDataServices.entity.CounterParty;
import com.refdata.RefDataServices.entity.Location;

@Component
public class RefDataServiceImpl implements RefDataService {
	
	@Autowired
	private RefDataDao refDataDao;

	@Override
	public Commodity getCommodityById(int id) {
		// TODO Auto-generated method stub
		return refDataDao.getCommodityById(id);
	}

	@Override
	public List<Commodity> getAllCommodities() {
		// TODO Auto-generated method stub
		return refDataDao.getAllCommodities();
	}

	@Override
	public CounterParty getCounterPartyById(int id) {
		// TODO Auto-generated method stub
		return refDataDao.getCounterPartyById(id);
	}

	@Override
	public List<CounterParty> getAllCounterParty() {
		// TODO Auto-generated method stub
		return refDataDao.getAllCounterParty();
	}

	@Override
	public Location getLocationById(int id) {
		// TODO Auto-generated method stub
		return refDataDao.getLocationById(id);
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return refDataDao.getAllLocations();
	}}
