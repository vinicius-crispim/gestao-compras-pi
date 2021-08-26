package com.pi.gestaocompras.repositories;

import org.springframework.stereotype.Repository;
import com.pi.gestaocompras.entities.OrdemCompra;
import org.springframework.data.repository.*;


@Repository
public interface OrdemCompraRepository extends CrudRepository<OrdemCompra, Long> {
    
}
