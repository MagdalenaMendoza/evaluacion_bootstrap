package com.keepcoding.app.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.keepcoding.app.web.Service.AlumnoService;
import com.keepcoding.app.web.Service.UsuarioService;
import com.keepcoding.app.web.entity.Alumno;
import com.keepcoding.app.web.entity.Usuario;




@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private UsuarioService usuarioService;

	
	// Login form  
    @GetMapping("/login")  
    public String login(Model modelo) { 
    	Usuario usuario = new Usuario();
    	modelo.addAttribute("usuario",usuario);
        return "login";
    }
    
	@PostMapping("/login")
	public String autUsuario(@ModelAttribute("usuario") Usuario usuario) {
					System.out.println(usuario.getUsername());
					System.out.println(usuario.getPass());
					Usuario miusuario = usuarioService.buscarUsername(usuario.getUsername());
					System.out.println(miusuario.isActivo());
					if (usuarioService.verificarUsuario(miusuario.getUsername(),miusuario.getPass())) {
						System.out.println("por aqui");
						return "redirect:/alumnos";
						}
					else {
						return "redirect:/login";
					}
		
				}
	
	@GetMapping("/usuario/new")
	
	public String newUsuario(Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuario",usuario);
		return "crear_usuario";
	}
	
	@PostMapping("/usuario")
	public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuario.setActivo(true);
		usuarioService.guardarUsuario(usuario);
		return "redirect:/login";
	}
	
	@GetMapping({"/","/alumnos"})
	public String Index(Model modelo){
			modelo.addAttribute("alumno", alumnoService.listarAlumnos());
			return "alumno";
	}
	

	
	@GetMapping("/alumno/new")
	
	public String newAlumno(Model modelo) {
		Alumno alumno = new Alumno();
		modelo.addAttribute("alumno",alumno);
		return "crear_alumno";
	}
	
	@PostMapping("/alumno")
	public String saveAlumno(@ModelAttribute("alumno") Alumno alumno) {
		alumnoService.guardarAlumno(alumno);
		return "redirect:/";
	}
	
	@GetMapping("/alumno/update/{id}")
	public String updateAlumnoForm(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("alumno_update",alumnoService.obtenerAlumno(id));
		return "editar_alumno";
	}

	@PostMapping("/alumno/{id}")
	public String updateEmpleado(@PathVariable Long id, @ModelAttribute("alumno_update") Alumno alumno) {
		Alumno alumnoExistente = alumnoService.obtenerAlumno(id);
		alumnoExistente.setId(id);
		alumnoExistente.setNombre(alumno.getNombre());
		alumnoExistente.setApellido(alumno.getApellido());
		alumnoExistente.setTelefono(alumno.getTelefono());
		alumnoExistente.setEmail(alumno.getEmail());
		alumnoExistente.setDni(alumno.getDni());
		alumnoExistente.setFecha_nac(alumno.getFecha_nac());
		alumnoService.actualizarAlumno(alumnoExistente);
		return "redirect:/";
	}
	
	@GetMapping("/alumno/eliminar/{id}")
	public String deleteAlumno(@PathVariable Long id) {
		alumnoService.eliminarAlumno(id);
		return "redirect:/";
	}
	
}
