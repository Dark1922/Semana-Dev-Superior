package com.devsuperior.dsvendas.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service //vai registrar nossa classe service como sendo um componente do sistema
//e dessa foram esse componente vai ser injetado em outros components

public class SaleService {//objeto de serviço que depende de objeto de repositorio dentro dele
	//vou declarar uma dependencia com seller repository
	
	@Autowired //vai injetar esse dependencia de forma transparente , vai ser injetada automaticamente sem falar new = instanciaçaõ etc
	private SaleRepository repository;
	
	@Autowired 
	private SellerRepository sellerepository;//PEGAMOS O SELLERREPOSITORY INSTANCIO ELE NUM MINUSCULO E PASSOU ABAIXO
	
	@Transactional(readOnly = true)//ctrl shif o o 2 import
	public Page<SaleDTO> findAll(Pageable pageable) {//pageable domain
		
		sellerepository.findAll();//TRAZER PRA MEMORIA A JPA VAI ARMAZENAR ESSES VENDEDORES EM CACH AI QND FOR BUSCA A VENDA
		//QUE DEPENDA DESSES VENDEDORES ELES VAO TÁ JÁ ARMAZENADOS EM MEMORIA
		
		Page<Sale> result = repository.findAll(pageable);//retornar uma chamada de repositorie pq ele vai faze a chamada do banco de dados
		return result.map(x -> new SaleDTO(x)); //retorna a lista result e vou converter em SellerDTO
	} 
//BUSCA PAGINADA DE VENDAS  SOMENTE ISSO AQUI JÁ ESTÁ PRONTO
}
 