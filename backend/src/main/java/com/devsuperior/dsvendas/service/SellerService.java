package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service //vai registrar nossa classe service como sendo um componente do sistema
//e dessa foram esse componente vai ser injetado em outros components

public class SellerService {//objeto de serviço que depende de objeto de repositorio dentro dele
	//vou declarar uma dependencia com seller repository
	
	@Autowired //vai injetar esse dependencia de forma transparente , vai ser injetada automaticamente sem falar new = instanciaçaõ etc
	private SellerRepository repository;
	
	//vou criar um método para retornar uma lista de  de seller
	public List<SellerDTO> findAll () {//findall pra buscar todos
		List<Seller> result = repository.findAll();//retornar uma chamada de repositorie pq ele vai faze a chamada do banco de dados
		//mudo pra sellerDTO vai retornar uma lista de seller, que é o resultado do banco de dados e repository
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList()); //retorna a lista result e vou converter em SellerDTO
	} //ela vai transverter minha coleção original para uma nova coleção que pode ser de um novo tipo inclusive que no caso
	//vai ser uma lista de SellerDTO , para cada x da minha lista original eu quero ent criar um novo objeto passando o new
	//SellerDTO passando o x como argumento ou seja vou pegar todo x da minha lista de seller e converter ele para DTO
	//e tem que tranverter a stream denovo para lista  com .collect(colectors).tolist()();

}
 