package com.lujan.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lujan.modelos.Cliente;
@Repository
public interface RepoCliente extends JpaRepository<Cliente, Long> {

}