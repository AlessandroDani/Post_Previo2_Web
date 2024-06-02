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
		System.out.println(manga);
		return mangaServices.postManga(manga);
	}
	
	@PutMapping("/mangas/{id}")
	public Manga putManga(@PathVariable Integer id, @RequestBody Manga manga){
		return mangaServices.putMangaId(id, manga);
	}
	
	@DeleteMapping("/manga/{id}")
	public Manga deleteManga(@PathVariable Integer id) {
		return mangaServices.deleteMangaId(id);
	}
}
