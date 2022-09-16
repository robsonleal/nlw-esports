package com.nlw.server.dtos.game;

import java.util.HashMap;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameCountDto {
    private UUID id;
    private String title;
    private String bannerUrl;
    private HashMap<String, Integer> count;
}
