package com.trade.TradeServices.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="user")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@Column(name="name")
	public String name;
	@ManyToMany
	@JoinTable(name="user_roles", joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
		    inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
	public List<Roles> roles;
	
}
