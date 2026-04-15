package gm.empleados.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import gm.empleados.Services.EmpleadoServicio;
import gm.empleados.models.Empleado;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
    private static final Logger logger= LoggerFactory.getLogger(IndexController.class);

    @Autowired
    EmpleadoServicio empleadoServicio;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inicar(ModelMap modelo) {
        List<Empleado> empleados = empleadoServicio.listarEmpleado();
        empleados.forEach((empleado)->logger.info(empleado.toString()));
        //Compartimos el modelo con la vista
        modelo.put("empleados",empleados);
        return "index";
    } 
    @RequestMapping(value = "/agregar", method=RequestMethod.GET)
    public String mostrarAgregar() {
		return "agregar";
	}
    
    @RequestMapping(value ="/agregar", method=RequestMethod.POST)
    public String agregar(@ModelAttribute ("empleoForma")Empleado empleado) {
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";
    }

    @RequestMapping(value = "/editar", method=RequestMethod.GET)
    public String moestrarEditar(@RequestParam int idEmpleado,ModelMap model) {
        Empleado empleado= empleadoServicio.buscarEmpleado(idEmpleado);
        logger.info("Empleado a editar" + empleado);
        model.put("empleado", empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "editar";
    }

    @RequestMapping(value = "/editar", method=RequestMethod.POST)
    public String editar(@ModelAttribute ("empleoForma")Empleado empleado) {
        logger.info("Empleado a guardar (editar)"+empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";
    }
    

    @RequestMapping(value = "/eliminar", method=RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado) {
        Empleado empleado= new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        empleadoServicio.eliminarEmpleado(empleado);
        return "redirect:/";
    }
    
	
    
}
