package com.pi.gestaocompras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.gestaocompras.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {
    
}
