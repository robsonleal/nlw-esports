package com.nlw.server.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "games")
public class Game implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    @Column(name = "banner_url")
    private String bannerUrl;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy="game")
    private List<Anuncio> anuncios;

    public Game(String title, String bannerUrl, List<Anuncio> anuncios) {
        this.title = title;
        this.bannerUrl = bannerUrl;
        this.anuncios = anuncios;
    }

}
