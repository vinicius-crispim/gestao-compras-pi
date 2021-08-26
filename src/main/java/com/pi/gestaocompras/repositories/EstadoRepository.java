package com.pi.gestaocompras.repositories;

import org.springframework.data.repository.*;
import com.pi.gestaocompras.entities.Estado;

public interface EstadoRepository extends CrudRepository<Estado,Long> {
    
}
