package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;


public interface SaleRepository extends JpaRepository<Sale, Long > {
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller ")//SELECT A PARTIR DE FOM DA CLASSE Sale

	List<SaleSumDTO> amountGroupedBySeller(); //A QUANTIA VENDIDA AGRUPADA POR VENDEDOR

	
	
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited),SUM(obj.deals) ) "
			+ "FROM Sale AS obj GROUP BY obj.seller ")//SELECT A PARTIR DE FOM DA CLASSE Sale

	List<SaleSuccessDTO> successGroupedBySeller();
	//A QUANTIA VENDIDA AGRUPADA POR VENDEDORobj.seller
	//SUCESSO DE GRUPO BY VENDEDOR TAXA DE SUCESSO AGRUPADA POR VENDEDOR 
	//VOU TER QUE CRIAR UM TIPO PARA RETORNAR ESSA ESTRUTA DE TABELA QUE BOTEI NO DISCORD DE VISITA E TALS
	//VAMOS CRIAS UM DTO
	//A SOMA DO OBJ.VISITED E TAMBÉM A DO OBJ.DEALS 
}
