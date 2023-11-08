package com.desing.pattern.padraoprojeto.repository;

import com.desing.pattern.padraoprojeto.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
