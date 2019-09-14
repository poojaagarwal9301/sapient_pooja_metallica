package com.marketdata.MarketDataServices.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marketdata.MarketDataServices.entity.Commodity;

@Component
public class CommodityDaoImpl implements CommodityDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(commodity);
	}

	@Override
	public Commodity findCommodityById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Commodity.class, id);
	}

	@Override
	public Commodity updateCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(commodity);
		return commodity;
	}

	@Override
	public void deleteCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(commodity);
	}

	@Override
	public List<Commodity> getAll() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM commodity;");
		query.setResultTransformer(Transformers.aliasToBean(Commodity.class));
		ArrayList<Commodity> entries = (ArrayList<Commodity>) query.getResultList();
		return entries;
	}}
