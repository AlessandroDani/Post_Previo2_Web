package com.ufps.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ufps.test.entities.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {

}
