package com.nlw.server.dtos.anuncio;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioListDto {
    private UUID id;
    private String name;
    private int yearsPlaying;
    private String[] weekDays;
    private String hourStart;
    private String hourEnd;
    private boolean useVoiceChannel;
    private LocalDateTime createdAt;
}
