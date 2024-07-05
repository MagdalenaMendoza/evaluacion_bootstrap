package com.keepcoding.app.web.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.app.web.Repository.AlumnoRepository;
import com.keepcoding.app.web.Service.AlumnoService;
import com.keepcoding.app.web.entity.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public List<Alumno> listarAlumnos() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(alumno);
	}

	@Override
	public Alumno obtenerAlumno(Long id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id).get();
	}

	@Override
	public Alumno actualizarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(alumno);
	}

	@Override
	public void eliminarAlumno(Long id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);
	}

}
