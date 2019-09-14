package com.metallica.Notificationservices.dto;

import java.util.Date;

public class TradeNotificationDTO {

	private Date tradeDate;
	private String commodity;
	private String side;
	private String location;
	private String counterParty;
	private String tradeStatus;
	private double quantity;
	private double price;
	private String currency;
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCounterParty() {
		return counterParty;
	}
	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}
	public String getTradeStatus() {
		return tradeStatus;
	}
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "TradeNotificationDTO [tradeDate=" + tradeDate + ", commodity="
				+ commodity + ", side=" + side + ", location=" + location
				+ ", counterParty=" + counterParty + ", tradeStatus="
				+ tradeStatus + ", quantity=" + quantity + ", price=" + price
				+ ", currency=" + currency + "]";
	}
	
	
}
