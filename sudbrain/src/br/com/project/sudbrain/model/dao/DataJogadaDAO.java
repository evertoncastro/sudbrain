package br.com.project.sudbrain.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.project.sudbrain.model.vo.Jogada;

public class DataJogadaDAO implements JogadaDAO {
	
	Connection con = null;
	public DataJogadaDAO(){
		super();
		con = ConnectionFactoryDAO.criaConexao();
	}

	@Override
	public boolean insereJogada(Jogada jogada) {
		String sql_insert_jogada = "insert into jogadas (id_usuario, pontos, id_escritura) values (?, ?, ?)";
		boolean statusInsercao = false;
		try{
			if(con.isClosed()){
				con = ConnectionFactoryDAO.criaConexao();
				System.out.println("Conexao para registro de jogada aberta");
			}
			PreparedStatement ps = con.prepareStatement(sql_insert_jogada);
			ps.setInt(1, jogada.getId_usuario());
			ps.setInt(2, jogada.getPontos());
			ps.setInt(3, jogada.getId_escritura());
			ps.execute();
			ps.close();
			con.close();
			System.out.println("Conexao para registro de jogada fechada");
		}catch(Exception e){
			System.out.println("Erro ao inserir "+e.getMessage());
		}
		statusInsercao = true;
		return statusInsercao;
	}

}
