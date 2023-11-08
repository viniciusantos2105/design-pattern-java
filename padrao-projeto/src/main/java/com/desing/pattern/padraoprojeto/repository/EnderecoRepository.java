package com.desing.pattern.padraoprojeto.repository;

import com.desing.pattern.padraoprojeto.models.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
