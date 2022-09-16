package com.nlw.server.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlw.server.Repositories.GameRepository;
import com.nlw.server.dtos.anuncio.AnuncioListDto;
import com.nlw.server.dtos.game.GameCountDto;
import com.nlw.server.helpers.Conversor;
import com.nlw.server.models.Anuncio;
import com.nlw.server.models.Game;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public Optional<Game> encontrarGamePorId(UUID id) {
        return repository.findById(id);
    }

    public List<GameCountDto> findAll() {
        List<Game> games = repository.findAll();
        List<GameCountDto> gamesDto = new ArrayList<>();

        for(Game game : games) {
            GameCountDto gameDto = new GameCountDto();
            BeanUtils.copyProperties(game, gameDto, "anuncios");
            HashMap<String, Integer> count = new HashMap<>();
            count.put("ads", game.getAnuncios().size());
            gameDto.setCount(count);
            gamesDto.add(gameDto);
        }       

        return gamesDto;
    }

    public List<AnuncioListDto> buscarAnunciosDoGame(UUID id) {
        //Preciso arrumar o retorno para um erro quando não tiver valores disponíveis
        //Preciso arrumar a autenticação do usuário que no momento não existe
        boolean UsuarioLogado = false;

        Optional<Game> game = repository.findById(id);
        List<Anuncio> anunciosDoGame = new ArrayList<>();
        List<AnuncioListDto> anunciosDoGameDto = new ArrayList<>();
        
        if (game.isPresent()) {
            anunciosDoGame = game.get().getAnuncios();

            if (!UsuarioLogado) {
                for (Anuncio anuncio : anunciosDoGame) {
                    AnuncioListDto anuncioSemDiscord = new AnuncioListDto();
                    BeanUtils.copyProperties(anuncio, anuncioSemDiscord, "weekDays", "hourStart", "hourEnd");
                    anuncioSemDiscord.setWeekDays(anuncio.getWeekDays().split(","));
                    anuncioSemDiscord.setHourStart(Conversor.minutosParaHoras(anuncio.getHourStart()));
                    anuncioSemDiscord.setHourEnd(Conversor.minutosParaHoras(anuncio.getHourEnd()));
                    anunciosDoGameDto.add(anuncioSemDiscord);
                }

                return anunciosDoGameDto;
            }

            //Usuário não logado, precisa de ajuste
            BeanUtils.copyProperties(anunciosDoGame, anunciosDoGameDto);
            return anunciosDoGameDto;
        } else {
            //Jogo não encontrado
            return anunciosDoGameDto;
        }
    }


}
