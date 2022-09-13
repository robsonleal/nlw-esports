package com.nlw.server.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nlw.server.models.Anuncio;

@RestController
@RequestMapping("/ads")
public class ServerController {
    @GetMapping("/hello")
    public String helloController(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name + "!";
    }

    @GetMapping
    public ResponseEntity<List<Anuncio>> buscarAnuncios() {
        Anuncio anuncio1 = new Anuncio(1L, "Anúncio 1");
        Anuncio anuncio2 = new Anuncio(1L, "Anúncio 2");
        List<Anuncio> anuncios = new ArrayList<>(List.of(anuncio1, anuncio2));

        return ResponseEntity.ok(anuncios);
    }

    
}