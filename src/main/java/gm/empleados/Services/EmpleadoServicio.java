package gm.empleados.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import gm.empleados.models.Empleado;
import gm.empleados.repository.EmpleadoRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoServicio implements IEmpleadosServicio {

    private final EmpleadoRepositorio empleadoRepositorio;

    @Override
    public Empleado buscarEmpleado(Integer idEmpleado) {
        return empleadoRepositorio.findById(idEmpleado).orElse(null);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }

    @Override
    public List<Empleado> listarEmpleado() {
        return empleadoRepositorio.findAll();
    }
    
    
}
