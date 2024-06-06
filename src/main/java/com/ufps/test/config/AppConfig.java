package com.ufps.test.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ufps.test.entities.Manga;
import com.ufps.test.models.MangaDTO;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        
        // Configuración específica para ignorar el campo 'id'
        modelMapper.addMappings(new PropertyMap<MangaDTO, Manga>() {
            @Override
            protected void configure() {
                skip(destination.getId()); // Ignora el campo 'id' al mapear
            }
        });
        
        return modelMapper;
    }
}
