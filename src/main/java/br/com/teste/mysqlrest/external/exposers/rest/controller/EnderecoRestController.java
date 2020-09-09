package br.com.teste.mysqlrest.external.exposers.rest.controller;

import br.com.teste.mysqlrest.external.exposers.rest.dto.responses.EnderecoResponse;
import br.com.teste.mysqlrest.external.exposers.rest.dto.requests.EnderecoRequest;
import br.com.teste.mysqlrest.ports.input.ManterEnderecoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoa/{idPessoa}/endereco")
@RestController
public class EnderecoRestController {

    @Autowired
    private ManterEnderecoPort manterEnderecoPort;


    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> getEnderecosByIdPessoa(@PathVariable("idPessoa") Long idPessoa) {
        return ResponseEntity.ok().body(manterEnderecoPort.findByIdPessoa(idPessoa));
    }

    @PostMapping
    public ResponseEntity<EnderecoResponse> criarEndereco(@PathVariable("idPessoa") Long idPessoa, @RequestBody EnderecoRequest enderecoRequest) {
        return ResponseEntity.ok().body(manterEnderecoPort.ciraEndereco(enderecoRequest, idPessoa));
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoResponse> alterarEndereco(@PathVariable("idPessoa") Long idPessoa, @PathVariable("idEndereco") Long idEndereco, @RequestBody EnderecoRequest enderecoRequest) {
        return ResponseEntity.ok().body(manterEnderecoPort.alteraEndereco(enderecoRequest, idEndereco, idPessoa));
    }

}