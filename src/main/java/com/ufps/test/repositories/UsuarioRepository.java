package com.ufps.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ufps.test.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);

}
