package com.refdata.RefDataServices.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.refdata.RefDataServices.entity.Commodity;
import com.refdata.RefDataServices.entity.CounterParty;
import com.refdata.RefDataServices.entity.Location;

@Component
public interface RefDataDao {

	Commodity getCommodityById(int id);
	
	List<Commodity> getAllCommodities();
	
	CounterParty getCounterPartyById(int id);
	
	List<CounterParty> getAllCounterParty();
	
	Location getLocationById(int id);
	
	List<Location> getAllLocations();
	
	
}
