package com.lujan.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lujan.modelos.Empleado;
@Repository
public interface RepoEmpleado extends JpaRepository<Empleado, Long> {

}