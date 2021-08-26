package com.pi.gestaocompras.repositories;
import org.springframework.data.repository.*;
import com.pi.gestaocompras.entities.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario,Long> {
    
}
