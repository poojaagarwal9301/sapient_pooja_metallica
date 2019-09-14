package com.marketdata.MarketDataServices.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NotificationDTO {

	private int id;
	private String code;
	private String description;
	private double price;
}
