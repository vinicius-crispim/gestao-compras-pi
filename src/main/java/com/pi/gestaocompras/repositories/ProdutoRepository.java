package com.pi.gestaocompras.repositories;

import org.springframework.stereotype.Repository;
import com.pi.gestaocompras.entities.Produto;
import org.springframework.data.repository.*;


@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    
}
