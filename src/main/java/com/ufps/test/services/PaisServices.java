package com.ufps.test.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.test.entities.Pais;
import com.ufps.test.repositories.PaisRepository;

@Service
public class PaisServices {
		@Autowired
		PaisRepository paisRepository;
		
		public Optional<Pais> getPaisID(Integer id) {
			return paisRepository.findById(id);
		}
}
