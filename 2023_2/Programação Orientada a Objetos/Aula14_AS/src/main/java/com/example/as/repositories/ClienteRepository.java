package com.example.as.repositories;
import com.example.as.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{
    List<Cliente> findByIdade(int idade);
}