package com.ufps.test.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.test.entities.Manga;

public interface MangaRepository extends JpaRepository<Manga, Integer> {

	
}
