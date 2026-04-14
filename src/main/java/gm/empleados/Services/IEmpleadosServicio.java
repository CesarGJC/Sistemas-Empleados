package gm.empleados.Services;

import java.util.List;

import gm.empleados.models.Empleado;

public interface IEmpleadosServicio {
    public List<Empleado> listarEmpleado();

    public Empleado buscarEmpleado(Integer idEmpleado);

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}
