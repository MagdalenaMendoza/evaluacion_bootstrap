package com.keepcoding.app.web.Service;

import java.util.List;


import com.keepcoding.app.web.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listarUsuario();
	public Usuario buscarUsername(String Username);
	
	public boolean verificarUsuario(String username, String password);
	
	public Usuario guardarUsuario(Usuario usuario);
	

}
