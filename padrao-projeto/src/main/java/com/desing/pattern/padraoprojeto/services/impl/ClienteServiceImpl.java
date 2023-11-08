package com.desing.pattern.padraoprojeto.services.impl;

import com.desing.pattern.padraoprojeto.models.Cliente;
import com.desing.pattern.padraoprojeto.models.Endereco;
import com.desing.pattern.padraoprojeto.repository.ClienteRepository;
import com.desing.pattern.padraoprojeto.repository.EnderecoRepository;
import com.desing.pattern.padraoprojeto.services.ClienteService;
import com.desing.pattern.padraoprojeto.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    //Singleton: Injetar os componenetes do Spring no @Autowired
    //Strategy: Implementar os métodos definidos na interface
    //Facade: Abstrarir integrações com subsistemas, provendo uma interface simples

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void inserir(Cliente cliente) {
        Endereco endereco = enderecoRepository.findById(cliente.getEndereco().getCep()).orElseGet(() ->{
            Endereco novoEndereco = viaCepService.consultarCep(cliente.getEndereco().getCep());
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    private void salvarClienteComCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cliente.getEndereco().getCep()).orElseGet(() ->{
            Endereco novoEndereco = viaCepService.consultarCep(cliente.getEndereco().getCep());
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
