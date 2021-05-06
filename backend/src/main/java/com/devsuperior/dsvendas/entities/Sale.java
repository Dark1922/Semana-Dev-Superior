package com.devsuperior.dsvendas.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sales") //nome da tabela no banco
public class Sale {
    
	@Id //chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //que o id vai ser auto icrementavel
	//o proprio banco de dados vai inserindo um novo id pra vc
	private Long id;//id
	private Integer visited;//visitar
	private Integer deals;//detalhes
	private Double amount; //quantia vendida
	private LocalDate date;
	
	@ManyToOne //muitos para um
	@JoinColumn(name = "seller_id") //chave estrangeira
	private Seller seller; //atributo Seller do tipo seller  composição das entidade
	
	//construtor sem argumento 
	public Sale() {
		
	}
	//construtor com argumentos 

public Sale(Long id, Integer visited, Integer deals, Double amount, LocalDate date, Seller seller) {
		
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Integer getVisited() {
	return visited;
}

public void setVisited(Integer visited) {
	this.visited = visited;
}

public Integer getDeals() {
	return deals;
}

public void setDeals(Integer deals) {
	this.deals = deals;
}

public Double getAmount() {
	return amount;
}

public void setAmount(Double amount) {
	this.amount = amount;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public Seller getSeller() {
	return seller;
}

public void setSeller(Seller seller) {
	this.seller = seller;
}
}
