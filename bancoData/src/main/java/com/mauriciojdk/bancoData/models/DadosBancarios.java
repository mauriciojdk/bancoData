package com.mauriciojdk.bancoData.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Dados_Bancarios")
@Data
@NoArgsConstructor @AllArgsConstructor
public class DadosBancarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "banco")
    private Integer banco;

    @Column(name = "conta")
    private Integer conta;

    @Column(name = "agencia")
    private Integer agencia;

    @OneToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private Pessoa pessoa;

}
