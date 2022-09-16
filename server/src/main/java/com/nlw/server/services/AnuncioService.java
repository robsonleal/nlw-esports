package com.nlw.server.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlw.server.Repositories.AnuncioRepository;
import com.nlw.server.Repositories.GameRepository;
import com.nlw.server.dtos.anuncio.AnuncioDto;
import com.nlw.server.helpers.Conversor;
import com.nlw.server.models.Anuncio;

@Service
public class AnuncioService {
    @Autowired
    private AnuncioRepository repository;

    @Autowired
    private GameRepository gameRepository;

    public HashMap<String, String> getDiscord(UUID id) {
        HashMap<String, String> discord = new HashMap<>();
        Optional<Anuncio> anuncio = repository.findById(id);
        if (anuncio.isPresent()) {
            discord.put("discord", anuncio.get().getDiscord());
            return discord;
        }
        //Arrumar para lançar erro caso não exista o anuncio
        return null;
    }

    public Anuncio criarAnuncio(UUID id, AnuncioDto anuncioDto) {
        Anuncio novoAnuncio = new Anuncio();
        BeanUtils.copyProperties(anuncioDto, novoAnuncio);
        novoAnuncio.setHourStart(Conversor.horasParaMinutos(anuncioDto.getHourStart()));
        novoAnuncio.setHourEnd(Conversor.horasParaMinutos(anuncioDto.getHourEnd()));
        novoAnuncio.setWeekDays(String.join(",", anuncioDto.getWeekDays()));
        novoAnuncio.setGame(gameRepository.findById(id).get());
        novoAnuncio.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        
        return repository.save(novoAnuncio);
    }
    
}
