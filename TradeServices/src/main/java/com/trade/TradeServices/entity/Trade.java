package com.trade.TradeServices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="trade")
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="trade_date")
	private Date tradeDate;
	@Column(name="commodity")
	private String commodity;
	@JoinColumn(name="side")
	@ManyToOne
	private Side side;
	@Column(name="location")
	private String location;
	@Column(name="counter_party")
	private String counterParty;
	@Column(name="currency")
	private String currency;
	@JoinColumn(name="trade_status")
	@ManyToOne
	private TradeStatus tradeStatus;
	@Column(name="quantity")
	private double quantity;
	@Column(name="price")
	private double price;
	@JoinColumn(name="manager_id")
	@ManyToOne
	private Manager manager;
	
}
