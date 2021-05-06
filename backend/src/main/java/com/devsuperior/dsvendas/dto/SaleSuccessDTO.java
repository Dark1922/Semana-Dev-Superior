package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.entities.Seller;

public class SaleSuccessDTO {

	private String sellerName; //vendedor name
	private Long visited; //EVITAR ICOMPATIBILIDADE COM BANCO DE DADOS LONG VISITED PARTE DA VISITA
	private Long deals; //PROMOÇÕES 
	public SaleSuccessDTO() {
		
	} //source generation contructor use field 


	//getter e setters do source
   //VAMOS TROCAR O STRING SELLERNAME QUE FICA NA 1 POSIÇÃO POR Seller seller
	public SaleSuccessDTO(Seller seller, Long visited, Long deals) {
	    sellerName = seller.getName();//VENDEDOR
		this.visited = visited;
		this.deals = deals;
	}


	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}


	public Long getVisited() {
		return visited;
	}


	public void setVisited(Long visited) {
		this.visited = visited;
	}


	public Long getDeals() {
		return deals;
	}



	public void setDeals(Long deals) {
		this.deals = deals;
	}

}
