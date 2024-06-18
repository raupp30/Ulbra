package com.example.as.controller;
import com.example.as.dtos.ClienteResponseDTO;
import com.example.as.entities.Cliente;
import com.example.as.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController
{
    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService)
    {
        this.clienteService = clienteService;
    }

    //Lista c/ todos clientes.
    @GetMapping
    public List<ClienteResponseDTO> getAllClients()
    {
        return clienteService.getAllClients();
    }

    //Lista c/ ID especifico
    @GetMapping("/{id}")
    public List<ClienteResponseDTO> getClienteById(@PathVariable long id)
    {
        return clienteService.getClienteById(id);
    }

    //Lista c/ idade especifica
    @GetMapping(params = "idade")
    public List<ClienteResponseDTO> getClientsByAge(@RequestParam int idade)
    {
        return clienteService.getClientsByIdade(idade);
    }

    //Adiciona um cliente
    @PostMapping
    public ClienteResponseDTO addClient(@RequestBody ClienteResponseDTO cliente)
    {
        return clienteService.addClient(cliente);
    }

    //Atualiza os dados de um cliente com ID especifico
    @PutMapping("/{id}")
    public String getClienteById(@PathVariable long id, @RequestBody Cliente updatedCliente)
    {
        clienteService.updateClient(id, updatedCliente);
        return "O cliente foi atualizado.";
    }

    // deletar cliente
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable long id)
    {
        clienteService.deleteClient(id);

        return "O cliente foi deletado!";
    }
}