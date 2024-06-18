package services;

import model.ClienteModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService {
    private ArrayList<ClienteModel> Clientes = new ArrayList<>();
    public ArrayList<ClienteModel> getAll (Integer idade){
        ArrayList<ClienteModel> queryClient = new ArrayList<>();
        if(idade != null){
            for(int i = 0; i < this.Clientes.size();i++){
                if(this.Clientes.get(i).idade() == idade){
                    queryClient.add(this.Clientes.get(i));
                }
            }
            return queryClient;
        }
        return this.Clientes;
    }
    public ClienteModel getById(int clientId){
        for(int i = 0; i < this.Clientes.size();i++){
            if(this.Clientes.get(i).id() == clientId){
                return this.Clientes.get(i);
            }
        }
        return null;
    }
    public String store(ClienteModel clienteData){
        this.Clientes.add(clienteData);
        return "Cliente adc";
    }
    public String update(ClienteModel clienteData, int clientId){
        for(int i = 0; i < this.Clientes.size();i++){
            if(this.Clientes.get(i).id() == clientId){
                this.Clientes.set(i,clienteData);
                break;
            }
        }
        return "Cliente foi atualizado";
    }
    public String delete(int clientId){
        for(int i = 0; i < this.Clientes.size();i++){
            if(this.Clientes.get(i).id() == clientId){
                this.Clientes.remove(i);
                break;
            }
        }
        return "Cliente deletado";
    }

}

