package com.pi.gestaocompras.repositories;

import org.springframework.data.repository.*;
import com.pi.gestaocompras.entities.Cidade;

public interface CidadeRepository extends CrudRepository<Cidade,Long> {
    
}
