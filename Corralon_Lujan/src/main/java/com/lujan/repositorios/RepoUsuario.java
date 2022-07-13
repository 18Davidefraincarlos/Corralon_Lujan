package com.lujan.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lujan.modelos.Usuario;
@Repository
public interface RepoUsuario extends JpaRepository<Usuario, Long> {

}