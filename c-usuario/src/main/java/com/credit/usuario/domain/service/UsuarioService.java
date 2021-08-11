package com.credit.usuario.domain.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.credit.usuario.domain.entities.Usuario;
import com.credit.usuario.domain.exceptions.DadoDuplicadoException;
import com.credit.usuario.domain.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	private BCryptPasswordEncoder encoder;
	
	public Usuario salvar(Usuario usuario) {
		boolean cpfEmUso = usuarioRepository.findByCpf(usuario.getCpf()).stream()
				.anyMatch(usuarioBD -> usuario.getId() == null ||  !usuarioBD.getId().equals(usuario.getId()));
		boolean usuarioEmUso = usuarioRepository.findByUsuario(usuario.getUsuario()).stream()
				.anyMatch(usuarioBD -> usuario.getId() == null || !usuarioBD.getId().equals(usuario.getId()));
		
		if(cpfEmUso || usuarioEmUso) {
			String msg = cpfEmUso ? "cpf" : "usuário";
			throw new DadoDuplicadoException(msg + " já cadastrado");
		}
		
		if(usuario.getSenha() != null && !usuario.getSenha().isBlank())
			usuario.setSenha(encoder.encode(usuario.getSenha()));
		
		return usuarioRepository.save(usuario);		
	}
	
	
}
