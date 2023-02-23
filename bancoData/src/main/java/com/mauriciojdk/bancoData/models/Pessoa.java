package com.mauriciojdk.bancoData.models;

import com.mauriciojdk.bancoData.LocalDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "Pessoa")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CsvBindByName(column = "id")
    private Integer id;

    @Column(name = "nome")
    @CsvBindByName(column = "nome")
    private String nome;

    @Column(name = "email")
    @CsvBindByName(column = "email")
    private String email;

    @Column(name = "data_nascimento")
    @CsvBindByName(column = "data_nascimento")
    @CsvDate(value = "dd-MM-yyyy HH:mm:ss")

    private Date dataNascimento;

    @Column(name = "idade")
    @CsvBindByName(column = "idade")
    private Integer idade;

}
