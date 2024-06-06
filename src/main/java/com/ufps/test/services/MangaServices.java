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
import com.ufps.test.repositories.UsuarioRepository;
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
	UsuarioRepository usuarioRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<Manga> getMangas() {
		return mangaRepository.findAll();
	}

	public Manga getMangaId(Integer id) {
		return mangaRepository.findById(id).orElseThrow(() -> new ErrorNotFound("Objeto no encontrado"));
	}

	public Manga deleteMangaId(Integer id) {
		Manga manga = mangaRepository.findById(id).orElseThrow(() -> new ErrorNotFound("Objeto no encontrado"));
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
        return mangaRepository.save(mangaPost);
	}

	public Manga putMangaId(Integer id, MangaDTO m) {
		 try {
		        Manga existingManga = mangaRepository.findById(id).orElseThrow(() -> new ErrorNotFound("Objeto no encontrado"));

		        modelMapper.map(m, existingManga);

		        existingManga.setId(id);

		        if (paisRepository.findById(existingManga.getPaisId().getId()).isEmpty()) {
		            throw new ErrorNotFound("Pais no existe");
		        }
		        if (tipoRepository.findById(existingManga.getTipoId().getId()).isEmpty()) {
		            throw new ErrorNotFound("Tipo no existe");
		        }

		        return mangaRepository.save(existingManga);

		    } catch (Exception e) {
		        throw new ErrorNotFound("Objeto no encontrado");
		    }
	}
	
	public List<Manga> getMangasFavoritos(String username) {
		Usuario u = new Usuario();
		try {
			u = usuarioRepository.findByUsername(username);
		} catch (Exception e) {
			 throw new ErrorNotFound("Usuario no existe");
		}
		if(u == null) {
			throw new ErrorNotFound("Usuario no conti");
		}
		return u.mangas;
	}

}
