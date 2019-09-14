package com.trade.TradeServices.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trade.TradeServices.entity.Trade;

@Component
public class TradeDaoImpl implements TradeDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistTrade(Trade trade) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(trade);
	}

	@Override
	public Trade findTradeById(int id) {
		// TODO Auto-generated method stub
		return (Trade) sessionFactory.getCurrentSession().get(Trade.class, id);
	}

	@Override
	public Trade updateTrade(Trade trade) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(trade);
		return trade;
	}

	@Override
	public void deleteTrade(Trade trade) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(trade);
	}

	
}
