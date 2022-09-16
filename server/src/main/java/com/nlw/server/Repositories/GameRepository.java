package com.nlw.server.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlw.server.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {
    
}
