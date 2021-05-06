package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Sale;
//nossa sellerrepository ela vai herdar o extends jparepository parecido com node 
//ela tem o Seller que é do tipo Long
public interface SaleRepository extends JpaRepository<Sale, Long > {

}
