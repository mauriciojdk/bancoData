package com.mauriciojdk.bancoData.controller;

import com.mauriciojdk.bancoData.models.DadosBancarios;
import com.mauriciojdk.bancoData.repository.DadosBancariosRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dadosbancarios")
public class DadosBancariosController {
    @Autowired
    private DadosBancariosRespository dadosBancariosRespository;

    public DadosBancariosController(DadosBancariosRespository dadosBancariosRespository){
        this.dadosBancariosRespository = dadosBancariosRespository;
    }

    @GetMapping
    public List<DadosBancarios> findAll(){
        return this.dadosBancariosRespository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save(@RequestBody DadosBancarios dadosBancarios){
        this.dadosBancariosRespository.save(dadosBancarios);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody DadosBancarios dadosBancarios){
        this.dadosBancariosRespository.findById(id).map(record -> {
            record.setId(dadosBancarios.getId());
            record.setBanco(dadosBancarios.getBanco());
            record.setAgencia(dadosBancarios.getAgencia());
            record.setConta(dadosBancarios.getConta());
            record.setPessoa(dadosBancarios.getPessoa());
            DadosBancarios updated = this.dadosBancariosRespository.save(record);
            return updated;
        });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        this.dadosBancariosRespository.deleteById(id);
    }

}
