package com.ufps.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ufps.test.entities.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
