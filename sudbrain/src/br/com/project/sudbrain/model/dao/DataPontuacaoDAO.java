package br.com.project.sudbrain.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.project.sudbrain.model.vo.Pontuacao;

public class DataPontuacaoDAO implements PontuacaoDAO {
	
	Connection con = null;
	
	public DataPontuacaoDAO(){
		super();
		con = ConnectionFactoryDAO.criaConexao();
	}
	
	public final String SQL_BUSCA_10PRIMEIROS = "select DISTINCT usu.nome, jog.pontos from jogadas jog "
			+ "inner join escrituras esc on jog.id_escritura = esc.id "
			+"inner join usuarios usu on jog.id_usuario = usu.id and esc.id = ? "
			+ "order by jog.pontos desc limit 10;";

	@Override
	public List<Pontuacao> buscaPontuacao(int escritura) {
		Pontuacao pontuacao = null;
		List<Pontuacao> lista = new ArrayList<Pontuacao>();
		try{
			if(con.isClosed()){
				con = ConnectionFactoryDAO.criaConexao();
				System.out.println("Conexao para busca de pontuacao aberta");
			}
			PreparedStatement ps = con.prepareStatement(SQL_BUSCA_10PRIMEIROS);
			ps.setInt(1, escritura);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				pontuacao = new Pontuacao();
				pontuacao.setNome(rs.getString(1));				
				pontuacao.setPontos(rs.getInt(2));
				lista.add(pontuacao);
			}
			ps.close();
			con.close();
			System.out.println("Conexao para busca de pontuacao encerrada");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}			
		return lista;
	}
	
}
