package br.com.project.sudbrain.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.project.sudbrain.model.vo.Usuario;

public class DataUsuarioDAO implements UsuarioDAO {
	Connection con = null;
	
	public DataUsuarioDAO(){
		super();
		con = ConnectionFactoryDAO.criaConexao();
	}
	
	public final String SQL_SELECT = "select * from usuarios where login = ? and senha = ?";
	public final String SQL_INSERT = "insert into usuarios (nome, login, senha, email, pontos) values(?, ?, ?, ?, 0)";
	public final String SQL_UPDATE = "update usuarios set pontos = ? where id = ?";
	public final String SQL_SELECT_DEZ_PRIMEIROS = "select nome, pontos from usuarios order by pontos desc limit 10";
	@Override
	public Usuario buscaUsuario(String login, String senha) {
		Usuario usuario = null;
		try{
			if(con.isClosed()){
				con = ConnectionFactoryDAO.criaConexao();
				System.out.println("Conexao para efetuacao de login aberta");
			}
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);
			ps.setString(1, login);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setLogin(rs.getString(3));
				usuario.setSenha(rs.getString(4));
				usuario.setPontos(rs.getInt(5));
			}
			ps.close();
			con.close();
			System.out.println("Conexao para efetuacao de login encerrada");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		if(usuario==null){
			return null;
		}else{
			return usuario;
		}	
		
	}
	@Override
	public boolean cadastrarUsuario(Usuario usuario) {
		boolean statusInsercao = false;
		try{
			if(con.isClosed()){
				con = ConnectionFactoryDAO.criaConexao();
				System.out.println("Conexao para cadastro de usuario aberta");
			}
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getEmail());			
			ps.execute();
			con.close();
			System.out.println("Conexao para cadastro de usuario fechada");
		}catch(Exception e){
			System.out.println("Erro ao inserir "+e.getMessage());
		}
		statusInsercao = true;
		return statusInsercao;
	}
	@Override
	public boolean alterarPontos(int id, int pontos) {
		boolean statusAlteracao = false;
		try{
			if(con.isClosed()){
				con = ConnectionFactoryDAO.criaConexao();
				System.out.println("Conexao para alteracao de pontos aberta");
			}
			PreparedStatement ps = con.prepareStatement(SQL_UPDATE);
			ps.setInt(1, pontos);
			ps.setInt(2, id);					
			ps.execute();
			ps.close();
			con.close();
			System.out.println("Conexao para alteracao de pontos encerrada");
		}catch(Exception e){
			System.out.println("Erro ao inserir "+e.getMessage());
		}
		statusAlteracao = true;
		return statusAlteracao;
	}
		
	@Override
	public List<Usuario> buscarMelhorPontuacao() {
		Usuario usuario = null;
		List<Usuario> lista = new ArrayList<Usuario>();
		try{
			if(con.isClosed()){
				con = ConnectionFactoryDAO.criaConexao();
				System.out.println("Conexao para busca da melhor pontuacao aberta");
			}
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_DEZ_PRIMEIROS);			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				usuario = new Usuario();
				usuario.setNome(rs.getString(1));				
				usuario.setPontos(rs.getInt(2));
				lista.add(usuario);
			}
			ps.close();
			con.close();
			System.out.println("Conexao para busca da melhor pontuacao fechada");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}		
		
		return lista;
	}
	
	
}
