package br.unipar.exemplorest.services;

import br.unipar.exemplorest.entities.Cliente;
import br.unipar.exemplorest.exceptions.ApiException;
import br.unipar.exemplorest.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    public Cliente getById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente insert(Cliente cliente) throws ApiException {
        validate(cliente);
        clienteRepository.save(cliente);
        return cliente;
    }
    private void validate(Cliente cliente) throws ApiException {
        if (cliente.getNome() == null ){
            throw new ApiException("Nome é obrigatório");
        }
        if (cliente.getNome().isEmpty()) {
            throw new ApiException("Nome é obrigatório");
        }
        if (cliente.getNome().length() > 60){
            throw new ApiException("Nome deve ter no máximo 60 caracteres");
        }
        if (cliente.getNome().length() < 30){
            throw new ApiException("Nome deve ter no mínimo 30 caracteres");
        }

    }
    public void update(Cliente cliente) {
        clienteRepository.save(cliente);
    }
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
