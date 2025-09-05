package com.peliculas.peliculas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.peliculas.peliculas.model.Pelicula;
import com.peliculas.peliculas.service.PeliculaService;

@RestController
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculaService.getAllMovies();
    }

    @GetMapping("/peliculas/{id}")
    public Optional<Pelicula> getPeliculaById(@PathVariable Long id) {
        return peliculaService.getMovieById(id);
    }
}
