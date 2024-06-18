package controller;

import model.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.ClienteService;

import java.util.ArrayList;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService userService){
        this.clienteService = userService;
    }
    @GetMapping()
    public ArrayList<ClienteModel> getAll(@RequestParam(name = "idade", required = false) Integer idade){
        return this.clienteService.getAll(idade);
    }
    @GetMapping("/{id}")
    public ClienteModel getById(@PathVariable int id){
        return this.clienteService.getById(id);
    }
    @PostMapping
    public String store(@RequestBody ClienteModel clienteData){
        return this.clienteService.store(clienteData);
    }
    @PutMapping("/{id}")
    public String update(@RequestBody ClienteModel clienteData,@PathVariable int id){
        return this.clienteService.update(clienteData,id);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return this.clienteService.delete(id);
    }
}
