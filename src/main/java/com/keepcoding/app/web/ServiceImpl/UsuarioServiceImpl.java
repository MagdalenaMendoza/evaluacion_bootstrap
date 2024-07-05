package com.keepcoding.app.web.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepcoding.app.web.Repository.UsuarioRepository;
import com.keepcoding.app.web.Service.UsuarioService;
import com.keepcoding.app.web.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario buscarUsername(String Username) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsername(Username);
	}

	@Override
	public boolean verificarUsuario(String username, String password) {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario != null) {
			String mipassword = usuarioRepository.findByUsername(username).getPass();
			
			if (mipassword == password && usuarioRepository.findByUsername(username).isActivo()) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	

}
