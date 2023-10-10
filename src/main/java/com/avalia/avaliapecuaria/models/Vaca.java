package com.avalia.avaliapecuaria.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Vaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int id_animal;

    private String nomeTabela;

    private String nomeFazenda;

    private Double scoreCorporal;
    private int scoreLocomotor;
    private int lote;
    private LocalDate dataRegistro;

    @Lob
    private byte[] fotoVaca;

}
