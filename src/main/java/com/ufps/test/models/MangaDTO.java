package com.ufps.test.models;

import java.util.Date;
import java.util.List;

import com.ufps.test.models.*;
import com.ufps.test.entities.Usuario;

import lombok.Data;

@Data
public class MangaDTO {
	String nombre;
	Date fecha_lanzamiento;
	Integer temporadas;
	PaisDTO paisId;
	Integer anime;
	Integer juego;
	Integer pelicula;
	TipoDTO tipoId;
	//List<UsuarioDTO> getUsuarios();
}
