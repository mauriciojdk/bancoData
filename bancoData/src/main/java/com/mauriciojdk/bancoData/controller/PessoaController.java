package com.mauriciojdk.bancoData.controller;

import com.mauriciojdk.bancoData.models.Pessoa;
import com.mauriciojdk.bancoData.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public List<Pessoa> findAll() {
        return this.pessoaRepository.findAll();
    }

    @PostMapping
    @RequestMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody Pessoa pessoa){
        System.out.println("oi");
        this.pessoaRepository.save(pessoa);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody Pessoa pessoa) {
        this.pessoaRepository.findById(id).map(record -> {
            record.setId(pessoa.getId());
            record.setNome(pessoa.getNome());
            record.setEmail(pessoa.getEmail());
            record.setIdade(pessoa.getIdade());
            record.setDataNascimento(pessoa.getDataNascimento());
            Pessoa updated = this.pessoaRepository.save(record);
            return updated;
        });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        this.pessoaRepository.deleteById(id);
    }
}
