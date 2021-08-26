package com.pi.gestaocompras.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pi.gestaocompras.entities.OrdemCompraItem;


@Repository
public interface OrdemCompraItemRepository extends CrudRepository<OrdemCompraItem, Long> {
    
}
