package com.peliculas.peliculas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
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
        // add HATEOAS links here
        List<Pelicula> peliculas = peliculaService.getAllMovies();
        peliculas.forEach(pelicula -> pelicula.add(
            linkTo(
                methodOn(PeliculaController.class).getPeliculaById(pelicula.getId())).withSelfRel()
            )    
        );
        return peliculas;
    }

    @GetMapping("/peliculas/{id}")
    public EntityModel<Pelicula> getPeliculaById(@PathVariable Long id) {
        Pelicula pelicula = peliculaService.getMovieById(id)
            .orElseThrow(() -> new PeliculaNotFoundException(id));

            
        return EntityModel.of(
            pelicula,
            linkTo(methodOn(PeliculaController.class).getPeliculaById(id)).withSelfRel(),
            linkTo(methodOn(PeliculaController.class).getPeliculas()).withRel("peliculas")
        );
    }

}
