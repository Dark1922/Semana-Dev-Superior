package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.entities.Seller;

public class SaleSumDTO {

	private String sellerName; //vendedor name
	private Double sum; //double que vai ser a soma  das vendas
	
	public SaleSumDTO() {
		
	} //source generation contructor use field 

	public SaleSumDTO(Seller seller, Double sum) {
		this.sellerName = seller.getName(); //pq vai ter que agrupar por seller em grupo n tem como agrupar pelo nome
		this.sum = sum;
	}
	
	 //getter e setters do source

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
	
}
