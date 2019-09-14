package com.trade.TradeServices.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO {

	private Date tradeDate;
	private String commodity;
	private String side;
	private String location;
	private String counterParty;
	private String tradeStatus;
	private double quantity;
	private double price;
	private String currency;
}
