package com.metallica.Notificationservices.dto;

public class MarketPricesNotificationDTO {

	private int id;
	private String code;
	private String description;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MarketPricesNotificationDTO [id=" + id + ", code=" + code
				+ ", description=" + description + ", price=" + price + "]";
	}
	
	
}
