package com.pi.gestaocompras.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pi.gestaocompras.entities.CotacaoCompraItem;

public interface CotacaoCompraItemRepository extends CrudRepository<CotacaoCompraItem,Long> {
    
}
