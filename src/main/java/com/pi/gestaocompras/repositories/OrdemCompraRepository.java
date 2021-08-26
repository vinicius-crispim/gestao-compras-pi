package com.pi.gestaocompras.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pi.gestaocompras.entities.OrdemCompra;


@Repository
public interface OrdemCompraRepository extends CrudRepository<OrdemCompra, Long> {
    
}
