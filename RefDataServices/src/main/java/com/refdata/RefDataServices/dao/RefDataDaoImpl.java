package com.refdata.RefDataServices.dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.refdata.RefDataServices.entity.Commodity;
import com.refdata.RefDataServices.entity.CounterParty;
import com.refdata.RefDataServices.entity.Location;

@Component
public class RefDataDaoImpl implements RefDataDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Commodity getCommodityById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Commodity.class, id);
	}

	@Override
	public List<Commodity> getAllCommodities() {
		// TODO Auto-generated method stub
		
		Query query = sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM commodity;");
		query.setResultTransformer(Transformers.aliasToBean(Commodity.class));
		ArrayList<Commodity> entries = (ArrayList<Commodity>) query.getResultList();
		return entries;
	}

	@Override
	public CounterParty getCounterPartyById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(CounterParty.class, id);
	}

	@Override
	public List<CounterParty> getAllCounterParty() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM counter_party;");
		query.setResultTransformer(Transformers.aliasToBean(CounterParty.class));
		ArrayList<CounterParty> entries = (ArrayList<CounterParty>) query.getResultList();
		return entries;
	}

	@Override
	public Location getLocationById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Location.class, id);
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM location;");
		query.setResultTransformer(Transformers.aliasToBean(Location.class));
		ArrayList<Location> entries = (ArrayList<Location>) query.getResultList();
		return entries;
	}
}
