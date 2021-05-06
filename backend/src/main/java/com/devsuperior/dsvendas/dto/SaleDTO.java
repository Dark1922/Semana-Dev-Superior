package com.devsuperior.dsvendas.dto;

import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Sale;

public class SaleDTO {

	private Long id;//id
	private Integer visited;//visitar
	private Integer deals;//detalhes
	private Double amount; //quantia vendida
	private LocalDate date;
	
	private SellerDTO seller;
	
	public SaleDTO() {//sem argumentos
		
	}
	//com argumentos do source getter e setter e using fields

	public SaleDTO(Long id, Integer visited, Integer deals, Double amount, LocalDate date, SellerDTO seller) {
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}
	public SaleDTO(Sale entity) { //copior o de cima pra ca , ctl shif o
		id = entity.getId();
		visited = entity.getVisited();
		deals = entity.getDeals();
		amount = entity.getAmount();
		date = entity.getDate();
		seller = new SellerDTO(entity.getSeller());	//ele é um seller e convertemos ele para  SellerDTO usa o construtor new recebendo essa entidade
		//então está copiando todos dados da entidade seller  para nossa sellerDTO
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

	public SellerDTO getSeller() {
		return seller;
	}

	public void setSeller(SellerDTO seller) {
		this.seller = seller;
	}
	
	
	
	
}
