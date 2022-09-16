package com.nlw.server.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "anuncios")
public class Anuncio implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    private String name;
    
    @Column(name = "years_playing")
    private int yearsPlaying;
    
    private String discord;
    
    @Column(name = "week_days")
    private String weekDays;
    
    @Column(name = "hour_start")
    private int hourStart;
    
    @Column(name = "hour_end")
    private int hourEnd;
    
    @Column(name = "use_voice_channel")
    private boolean useVoiceChannel;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_game")
    private Game game;

    public Anuncio(String name, int yearsPlaying, String discord, String weekDays, int hourStart, int hourEnd,
            boolean useVoiceChannel, LocalDateTime createdAt, Game game) {
        this.name = name;
        this.yearsPlaying = yearsPlaying;
        this.discord = discord;
        this.weekDays = weekDays;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.useVoiceChannel = useVoiceChannel;
        this.createdAt = createdAt;
        this.game = game;
    }

}
