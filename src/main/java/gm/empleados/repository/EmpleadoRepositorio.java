package gm.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gm.empleados.models.Empleado;


public interface EmpleadoRepositorio extends JpaRepository<Empleado,Integer>{
    
}
