package com.mauriciojdk.bancoData.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pessoa")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "data_nascimento")
    private LocalDateTime dataNascimento;

    @Column(name = "idade")
    private Integer idade;

    @OneToOne(mappedBy = "pessoa")
    private DadosBancarios banco;


}
