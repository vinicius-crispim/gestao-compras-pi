package com.pi.gestaocompras.repositories;

import org.springframework.data.repository.*;
import com.pi.gestaocompras.entities.Fornecedor;

public interface FornecedorRepository extends CrudRepository<Fornecedor,Long> {
    
}
