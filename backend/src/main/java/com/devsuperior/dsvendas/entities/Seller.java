package com.devsuperior.dsvendas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sellers") //nome da tabela dos vendedor 
public class Seller {
	
	@Id //chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //que o id vai ser auto icrementavel
	//o proprio banco de dados vai inserindo um novo id pra vc
	private Long id;
	private String name; //declaramos os 2 atributos de nossa classe
	
	@OneToMany(mappedBy = "seller") //um para muitos "seller" é a entidade que está no Sale.java no joincolumn
	private List<Sale> sales = new ArrayList<>(); //lista de vendas
	//instancia a coleção nesse arraylist classe correpondente a interface
	
	//vamos criar um construtor padrão sem argumento
	
	public Seller() {
		
	}

	public Seller(Long id, String name) {
		
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sale> getSales() {
		return sales;
	}
	

}
