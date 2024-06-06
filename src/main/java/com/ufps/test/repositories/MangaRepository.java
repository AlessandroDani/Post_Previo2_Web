package com.ufps.test.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.test.entities.Manga;
import com.ufps.test.entities.Usuario;
import com.ufps.test.models.PaisDTO;
import com.ufps.test.models.TipoDTO;

public interface MangaRepository extends JpaRepository<Manga, Integer> {

	
}
