package com.peliculas.peliculas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.peliculas.peliculas.model.Pelicula;
import com.peliculas.peliculas.repository.PeliculaRepository;

@ExtendWith(MockitoExtension.class)
public class PeliculaServiceTest {
    @InjectMocks
    private PeliculaServiceImpl peliculaService;

    @Mock
    private PeliculaRepository peliculaRepository;

    @Test
    public void testGetAllMovies() {
        // Arrange
        when(peliculaRepository.findAll()).thenReturn(List.of(new Pelicula(), new Pelicula()));

        // Act
        var peliculas = peliculaService.getAllMovies();

        // Assert
        assertNotNull(peliculas);
        assertEquals(2, peliculas.size());
    }
}
