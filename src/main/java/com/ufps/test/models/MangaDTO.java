package com.ufps.test.models;

import java.util.Date;
import java.util.List;

import com.ufps.test.models.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ufps.test.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangaDTO {
	Integer id;
	String nombre;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	Date fechaLanzamiento;
	
	Integer temporadas;
	Integer paisId;
	Boolean anime;
	Boolean juego;
	Boolean pelicula;
	Integer tipoId;
	//List<UsuarioDTO> getUsuarios();
}
