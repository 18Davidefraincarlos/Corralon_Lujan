package com.lujan.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lujan.modelos.Detalle;
@Repository
public interface RepoDetalle extends JpaRepository<Detalle, Long> {

}