package com.nlw.server.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlw.server.dtos.anuncio.AnuncioDto;
import com.nlw.server.dtos.anuncio.AnuncioListDto;
import com.nlw.server.dtos.game.GameCountDto;
import com.nlw.server.models.Anuncio;
import com.nlw.server.services.AnuncioService;
import com.nlw.server.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService service;

    @Autowired
    private AnuncioService anuncioService;

    @GetMapping
    public ResponseEntity<List<GameCountDto>> buscarGames() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}/ads")
    public ResponseEntity<List<AnuncioListDto>> buscarAnunciosDoGame(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarAnunciosDoGame(id));
    }

    @PostMapping("/{id}/ads")
    public ResponseEntity<Anuncio> criarAnuncio(@PathVariable(value = "id") UUID id, @RequestBody AnuncioDto anuncioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(anuncioService.criarAnuncio(id, anuncioDto));
    }

}
