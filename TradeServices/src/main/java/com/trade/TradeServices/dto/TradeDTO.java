package com.trade.TradeServices.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.trade.TradeServices.entity.Manager;

@Getter
@Setter
public class TradeDTO {

	private int id;
	private Date tradeDate;
	private String commodity;
	private String side;
	private String location;
	private String counterParty;
	private String tradeStatus;
	private double quantity;
	private double price;
	private Manager manager;
	private String currency;
	
	
}
