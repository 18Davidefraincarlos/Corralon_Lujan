package com.lujan.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lujan.modelos.Factura;
@Repository
public interface RepoFactura extends JpaRepository<Factura, Long> {

}