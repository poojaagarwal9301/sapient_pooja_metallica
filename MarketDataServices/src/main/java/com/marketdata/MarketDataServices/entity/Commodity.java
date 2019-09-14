package com.marketdata.MarketDataServices.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="commodity")
public class Commodity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="code")
	private String code;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private int price;
	@Column(name="last_price")
	private int last_price;
	@CreationTimestamp
	@Column(name="created")
    private Timestamp created;
    @UpdateTimestamp
    @Column(name="last_updated")
    private Timestamp last_updated;
	
}