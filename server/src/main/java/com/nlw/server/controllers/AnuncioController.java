package com.nlw.server.controllers;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlw.server.services.AnuncioService;

@RestController
@RequestMapping("/ads")
public class AnuncioController {
    @Autowired
    private AnuncioService service;

    @GetMapping("/{id}/discord")
    public ResponseEntity<HashMap<String, String>> retornarDiscodAnuncio(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getDiscord(id));
    }
    
}
