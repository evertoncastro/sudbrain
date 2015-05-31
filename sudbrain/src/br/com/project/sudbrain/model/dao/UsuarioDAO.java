package br.com.project.sudbrain.model.dao;

import java.util.List;

import br.com.project.sudbrain.model.vo.Usuario;

public interface UsuarioDAO {
	
	public Usuario buscaUsuario(String login, String senha);
	public boolean cadastrarUsuario(Usuario usuario);
	public boolean alterarPontos(int id, int pontos);
	public List<Usuario> buscarMelhorPontuacao();
}
