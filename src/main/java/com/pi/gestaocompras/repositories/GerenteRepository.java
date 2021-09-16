package com.pi.gestaocompras.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.gestaocompras.entities.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente,Long> {
    
}
