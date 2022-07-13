package com.lujan.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lujan.modelos.Producto;
@Repository
public interface RepoProducto extends JpaRepository<Producto, Long> {

}
