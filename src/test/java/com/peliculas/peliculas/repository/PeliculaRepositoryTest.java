package com.peliculas.peliculas.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaRepositoryTest {
    @Autowired 
    private PeliculaRepository peliculaRepository;

    @Test
    public void getAllMovies() {
        // arrange
        // act
        var peliculas = peliculaRepository.findAll();
        
        
        // assert
        assertNotNull(peliculas);
        assertTrue(peliculas.size() > 0);
    }
}
