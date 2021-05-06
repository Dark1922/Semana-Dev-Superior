package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SellerDTO implements Serializable {//n vai ter relação com banco de dados nem nada mas a entidade tem
 
	 //correção do SellerDTO com o  Serializable ai da essa verssão massa ai tira o eerro
	private static final long serialVersionUID = 1L;
	
	//Serializable para que os objetos sejam convertidos para bytes do DTO salvo em arquivo , trafegado em rede essas coisa do tipo
	private Long id;   //entidades do seller
	private String name; 
	
	public SellerDTO() { //construtoe sem arguemntos
		
	}
	
	//coonstrutor com argumento botão direito do mause source/ generate contructor using fields e cria abaixo
	public SellerDTO(Long id, String name) {
		
		this.id = id;
		this.name = name;
	}
public SellerDTO(Seller entity) {//recebe entidade seller ctl shif o importa o seller
		//par aque eu possa copiar facilmente os dados de uam entidade  para um SellerDTO 
		id = entity.getId(); //eu chamo aqui um construtor da classe  ja passando a entidade 
		name = entity.getName(); //as entidades feito abaixo com as entidade de cima
	}
	
	//botao direito do mause source / getters e setters

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
	
}
