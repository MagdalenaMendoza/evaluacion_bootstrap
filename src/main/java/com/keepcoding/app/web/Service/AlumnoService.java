package com.keepcoding.app.web.Service;

import java.util.List;

import com.keepcoding.app.web.entity.Alumno;


public interface AlumnoService {
	
	public List<Alumno> listarAlumnos();
	
	public Alumno guardarAlumno(Alumno alumno);
	//metodo para obtener empleado por id
	public Alumno obtenerAlumno(Long id);
	//metodo para actualizar un empleado
	public Alumno actualizarAlumno(Alumno alumno);
	//metodo para eliminar un empleado
	public void eliminarAlumno(Long id);
}
