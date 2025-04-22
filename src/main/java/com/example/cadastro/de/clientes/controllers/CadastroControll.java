package com.example.cadastro.de.clientes.controllers;

import com.example.cadastro.de.clientes.dtos.CadastroRecordDto;
import com.example.cadastro.de.clientes.models.CadastroModel;
import com.example.cadastro.de.clientes.repositories.CadastroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CadastroControll {

    @Autowired
    CadastroRepository cadastroRepository;
//comando para cadastrar um cliente
    @PostMapping("/cadastro")
    public ResponseEntity<CadastroModel> savecadastro(@RequestBody @Valid CadastroRecordDto cadastroRecordDto){
        var cadastroModel = new CadastroModel();
        BeanUtils.copyProperties(cadastroRecordDto, cadastroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroRepository.save(cadastroModel));
    }
    //para mostrar todos os clientes já cadastrados
    @GetMapping("/cadastro")
    public ResponseEntity<List<CadastroModel>> getALLcadastros(){
        return ResponseEntity.status(HttpStatus.OK).body(cadastroRepository.findAll());
    }
    //para mostrar apenas um cliente
    @GetMapping("/cadastro/{id}")
    public ResponseEntity<Object> getOnecadastro(@PathVariable(value = "id")UUID id){
        Optional<CadastroModel> cadastro0 = cadastroRepository.findById(id);
        if(cadastro0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cadastro0.get());
    }
    //atualizar os dados de um cliente
    @PutMapping("/cadastro/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id")UUID id, @RequestBody @Valid CadastroRecordDto cadastroRecordDto){
        Optional<CadastroModel> cadastro0 = cadastroRepository.findById(id);
        if(cadastro0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
        var cadastroModel = cadastro0.get();
        BeanUtils.copyProperties(cadastroRecordDto, cadastroModel);
        return ResponseEntity.status(HttpStatus.OK).body(cadastroRepository.save(cadastroModel));
    }
    //deletar o cadastro de um cliente
    @DeleteMapping("/cadastro/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id")UUID id){
        Optional<CadastroModel> cadastro0 = cadastroRepository.findById(id);
        if (cadastro0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
        cadastroRepository.delete(cadastro0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }
}
