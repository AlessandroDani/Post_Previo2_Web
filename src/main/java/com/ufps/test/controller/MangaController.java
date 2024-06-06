package com.ufps.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.test.services.MangaServices;
import com.ufps.test.entities.*;
import com.ufps.test.error.ErrorNotFound;
import com.ufps.test.models.MangaDTO;

@RestController
public class MangaController {
	
	@Autowired
	MangaServices mangaServices;

	@GetMapping("/status")
	public String status() {
		return "SERVIDOR ENCENDIDO";
	}
	
	/**
	 * 1. Metodo de obtener todos los mangas
	 * @return Lista de todos los mangas
	 */
	@GetMapping("/mangas")
	public List<Manga> getMangas(){
		return mangaServices.getMangas();
	}
	
	/**
	 * 2. Metodo de obtener manga por id
	 * @param id
	 * @return Manga con el id ingresado
	 */
	@GetMapping("/mangas/{id}")
	public Manga getMangas(@PathVariable("id") Integer id){
		return mangaServices.getMangaId(id);
	}
	
	@PostMapping("/manga")
	public Manga postManga(@RequestBody MangaDTO manga) {
		if(manga.getAnime() == null) throw new ErrorNotFound("el campo anime es obligatorio");
		if(manga.getJuego() == null) throw new ErrorNotFound("el campo juego es obligatorio");
		if(manga.getPelicula() == null) throw new ErrorNotFound("el campo pelicula es obligatorio");
		if(manga.getFechaLanzamiento() == null) throw new ErrorNotFound("el campo dste es obligatorio");
		if(manga.getNombre() == null) throw new ErrorNotFound("el campo nombre es obligatorio");
		if(manga.getPaisId() == null) throw new ErrorNotFound("el campo paisId es obligatorio");
		if(manga.getTemporadas() == null) throw new ErrorNotFound("el campo temporada es obligatorio");
		if(manga.getTipoId() == null) throw new ErrorNotFound("el campo tipoId es obligatorio");
		return mangaServices.postManga(manga);
	}
	
	@PutMapping("/mangas/{id}")
	public Manga putManga(@PathVariable("id") Integer id, @RequestBody MangaDTO manga){
		return mangaServices.putMangaId(id, manga);
	}
	
	@DeleteMapping("/manga/{id}")
	public Manga deleteManga(@PathVariable("id") Integer id) {
		return mangaServices.deleteMangaId(id);
	}
	
	@GetMapping("/usuarios/{username}/favoritos")
	public List<Manga> getFavoritos(@PathVariable("username") String username) {
		return mangaServices.getMangasFavoritos(username);
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> getUser(){
		return mangaServices.getUser();
	}
	
	@DeleteMapping("/usuarios/{username}/favoritos/{mangaId}")
	public List<Manga> deleteUserManga(@PathVariable("username") String username, @PathVariable("id") Integer id ) {
		return mangaServices.deleteFavoriteManga(username, id);
	}
	
}
