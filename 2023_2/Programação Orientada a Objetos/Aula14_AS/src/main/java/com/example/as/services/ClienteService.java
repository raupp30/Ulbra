package com.example.as.services;
import com.example.as.dtos.ClienteResponseDTO;
import com.example.as.entities.Cliente;
import com.example.as.Exceptions.NotFoundClienteException;
import com.example.as.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService
{
    private ClienteRepository repository;
    @Autowired
    public ClienteService(ClienteRepository repository)
    {
        this.repository = repository;
    }

    //Irá nos trazer uma lista c/ todos os clientes cadastrados.
    public List<ClienteResponseDTO> getAllClients()
    {
        List<ClienteResponseDTO> listaDeClientes = new ArrayList<>();
        List<Cliente> resultado = this.repository.findAll();

        for(int i = 0; i < resultado.size(); i++)
        {
            ClienteResponseDTO dto = new ClienteResponseDTO();
            dto.setNome(resultado.get(i).getNome());
            dto.setProfissao(resultado.get(i).getProfissao());
            dto.setIdade(resultado.get(i).getIdade());
            listaDeClientes.add(dto);
        }
        return listaDeClientes;
    }

    //Adiciona um cliente com seu nome, idade e profissão.
    public ClienteResponseDTO addClient(ClienteResponseDTO cliente)
    {
        Cliente clienteDtoToCliente = new Cliente(cliente.getNome(), cliente.getIdade(), cliente.getProfissao());
        Cliente resultadoSalvo = this.repository.save(clienteDtoToCliente);
        return new ClienteResponseDTO(resultadoSalvo.getNome(), resultadoSalvo.getIdade(), resultadoSalvo.getProfissao());
    }

    //Atualiza um cliente conforme o ID selecionado.
    public String updateClient(long id, Cliente updatedCliente)
    {
        Cliente atualizar = repository.findById(id).orElse(null);
        BeanUtils.copyProperties(updatedCliente, atualizar, "id");
        repository.save(atualizar);
        return "O cliente foi atualizado.";
    }

    //Remove um cliente conforme ID selecionado.
    public String deleteClient(long id)
    {
        Cliente cliente = repository.findById(id).orElse(null);
        repository.delete(cliente);
        return "O cliente foi removido.";
    }

    //Irá nos trazer uma cliente filtrado pelo ID.
    public List<ClienteResponseDTO> getClienteById(long id)
    {
        List<ClienteResponseDTO> listaDeClientes = new ArrayList<>();
        List<Cliente> resultado = this.repository.findAll();
        for(int i = 0; i < resultado.size(); i++)
        {
            if(resultado.get(i).getId() == id)
            {
                ClienteResponseDTO dto = new ClienteResponseDTO();
                dto.setNome(resultado.get(i).getNome());
                dto.setProfissao(resultado.get(i).getProfissao());
                dto.setIdade(resultado.get(i).getIdade());
                listaDeClientes.add(dto);
            }
        }if(resultado.get(0) == null)
        {
            throw new NotFoundClienteException();
        }else
        {
            return listaDeClientes;
        }
    }

    //Irá nos trazer uma cliente filtrado pela idade.
    public List<ClienteResponseDTO> getClientsByIdade(int idade)
    {
        List<ClienteResponseDTO> listaDeClientes = new ArrayList<>();
        List<Cliente> resultado = this.repository.findAll();
        for(int i = 0; i < resultado.size(); i++)
        {
            if(resultado.get(i).getIdade() == idade)
            {
                ClienteResponseDTO dto = new ClienteResponseDTO();
                dto.setNome(resultado.get(i).getNome());
                dto.setProfissao(resultado.get(i).getProfissao());
                dto.setIdade(resultado.get(i).getIdade());
                listaDeClientes.add(dto);
            }
        }
        return listaDeClientes;
    }
}