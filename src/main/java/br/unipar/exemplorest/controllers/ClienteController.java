package br.unipar.exemplorest.controllers;

import br.unipar.exemplorest.entities.Cliente;
import br.unipar.exemplorest.exceptions.ApiException;
import br.unipar.exemplorest.services.ClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public String getById(@PathVariable int id) {
        return "Cliente com id " + id;
    }
    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(clienteService.insert(cliente));
        } catch (ApiException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id) {
        clienteService.update(new Cliente());
        return ResponseEntity.ok("Cliente com id " + id + " atualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.ok("Cliente com id " + id + " deletado");
    }
}
