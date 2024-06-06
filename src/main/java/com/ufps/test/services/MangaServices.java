package com.ufps.test.services;

import java.lang.reflect.Field;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.test.entities.*;
import com.ufps.test.error.ErrorNotFound;
import com.ufps.test.models.MangaDTO;
import com.ufps.test.models.PaisDTO;
import com.ufps.test.models.TipoDTO;
import com.ufps.test.repositories.MangaRepository;
import com.ufps.test.repositories.PaisRepository;
import com.ufps.test.repositories.TipoRepository;
import com.ufps.test.services.*;

@Service
public class MangaServices {

	@Autowired
	MangaRepository mangaRepository;

	@Autowired
	PaisRepository paisRepository;

	@Autowired
	TipoRepository tipoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<Manga> getMangas() {
		return mangaRepository.findAll();
	}

	public Manga getMangaId(Integer id) {
		return mangaRepository.findById(id).orElseThrow(() -> new ErrorNotFound("Objeto no encontrado"));
	}

	public Manga deleteMangaId(Integer id) {
		Manga manga = mangaRepository.getById(id);
		mangaRepository.deleteById(id);
		return manga;
	}

	public Manga postManga(MangaDTO manga) {
		Manga mangaPost = modelMapper.map(manga, Manga.class);
		String mensaje = "";
		try {
		    if (paisRepository.findById(mangaPost.getPaisId().getId()).isEmpty()) {
		        mensaje = "Pais no existe";
		        throw new ErrorNotFound(mensaje);
		    }
		    
		    if (tipoRepository.findById(mangaPost.getTipoId().getId()).isEmpty()) {
		        mensaje = "Tipo no existe";
		        throw new ErrorNotFound(mensaje);
		    }
		} catch (ErrorNotFound e) {
		    throw e;
		}
		/*
		Field[] fields = Manga.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); 
            try {
                String name = field.getName();
                Object value = field.get(manga);
                if(value == null || value.equals("")) {
                	throw new ErrorNotFound("El campo " + name + " es obligatorio");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        */
        return mangaRepository.save(mangaPost);
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
