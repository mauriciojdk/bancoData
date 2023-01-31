package com.mauriciojdk.bancoData.repository;

import com.mauriciojdk.bancoData.models.DadosBancarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosBancariosRespository extends JpaRepository<DadosBancarios, Integer> {
}
