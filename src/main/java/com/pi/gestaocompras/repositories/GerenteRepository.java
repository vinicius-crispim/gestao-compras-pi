package com.pi.gestaocompras.repositories;
import org.springframework.data.repository.*;
import com.pi.gestaocompras.entities.Gerente;

public interface GerenteRepository extends CrudRepository<Gerente,Long> {
    
}
