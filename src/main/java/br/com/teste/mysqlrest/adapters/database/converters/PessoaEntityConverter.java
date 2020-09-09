package br.com.teste.mysqlrest.adapters.database.converters;

import br.com.teste.mysqlrest.external.consumers.database.entities.PessoaEntity;
import br.com.teste.mysqlrest.usecases.model.Pessoa;

public class PessoaEntityConverter {
    public static PessoaEntity toEntity(Pessoa pessoa) {
        return PessoaEntity.builder()
                .nome(pessoa.getNome())
                .email(pessoa.getEmail())
                .enderecos(EnderecoEntityConverter.toEntity(pessoa.getEnderecos()))
                .build();
    }

    public static PessoaEntity toEntity(Pessoa pessoa, Long idPessoa) {
        return PessoaEntity.builder()
                .id(idPessoa)
                .nome(pessoa.getNome())
                .email(pessoa.getEmail())
                .enderecos(EnderecoEntityConverter.toEntity(pessoa.getEnderecos()))
                .build();
    }

    public static Pessoa toModel(PessoaEntity pessoaEntity) {
        return Pessoa.builder()
                .id(pessoaEntity.getId())
                .nome(pessoaEntity.getNome())
                .email(pessoaEntity.getEmail())
                .enderecos(EnderecoEntityConverter.toModel(pessoaEntity.getEnderecos()))
                .build();
    }
}
