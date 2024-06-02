package com.ufps.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.test.entities.Manga;
import com.ufps.test.error.ErrorNotFound;
import com.ufps.test.models.MangaDTO;
import com.ufps.test.repositories.MangaRepository;

@Service
public class MangaServices {

	@Autowired
	MangaRepository mangaRepository;

	public List<Manga> getMangas() {
		return mangaRepository.findAll();
	}

	public Manga getMangaId(Integer id) {
		return mangaRepository.findById(id)
				.orElseThrow(() -> new ErrorNotFound("Objeto no encontrado"));
	}

	public Manga deleteMangaId(Integer id) {
		Manga manga = mangaRepository.getById(id);
		mangaRepository.deleteById(id);
		return manga;
	}

	public Manga postManga(MangaDTO manga) {
		Manga mangaPost = new Manga();
		mangaPost.setAnime(manga.getAnime());
		mangaPost.setFechaLanzamiento(manga.getFecha_lanzamiento());
		mangaPost.setJuego(manga.getJuego());
		mangaPost.setNombre(manga.getNombre());
		// mangaPost.setPaisId(manga.getPaisId());
		mangaPost.setPelicula(manga.getPelicula());
		mangaPost.setTemporadas(manga.getTemporadas());
		// mangaPost.setTipoId(manga.getTipoId());
		// mangaPost.setUsuarios(manga.getUsuarios());
		// return mangaRepository.save(manga);
		return null;
	}

	public Manga putMangaId(Integer id, Manga manga) {
		Manga mangaBuscado = mangaRepository.getById(id);
		mangaBuscado.setAnime(manga.getId());
		mangaBuscado.setFechaLanzamiento(manga.getFechaLanzamiento());
		mangaBuscado.setJuego(manga.getJuego());
		mangaBuscado.setNombre(manga.getNombre());
		mangaBuscado.setPaisId(manga.getPaisId());
		mangaBuscado.setPelicula(manga.getPelicula());
		mangaBuscado.setTemporadas(manga.getTemporadas());
		mangaBuscado.setTipoId(manga.getTipoId());
		mangaBuscado.setUsuarios(manga.getUsuarios());
		mangaRepository.deleteById(id);

		return mangaBuscado;
	}

}
