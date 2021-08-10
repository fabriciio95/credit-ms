package com.credit.cartao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credit.cartao.domain.entities.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long>{

}
