package br.com.project.sudbrain.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.project.sudbrain.model.vo.Pergunta;

public class DataPerguntaDAO implements PerguntaDAO {
	static char cAspas  = (char) '"';
	//private final String SQL_BUSCA_ID = "select * from public.\"perguntas\" where id = ?";
	String sql_busca_pergunta = null;
 	public final String CADASTRA_PERGUNTA = "insert into perguntas_doutrinaeconvenios values(default, ?, ?, ?, ?, ?, ?, ?)";
	
 	Connection con = null;
	
	//Metodo construtor da classe
	public DataPerguntaDAO(){
		super();
		con = ConnectionFactoryDAO.criaConexao();
	}
	
	@Override
	public List<Pergunta> buscaPerguntaNivel(int nivel, String escritura) {
		if(escritura.equals("mormon")) sql_busca_pergunta = "select * from public.perguntas_livrodemormon where nivel = ?";
		else if(escritura.equals("doutrina"))sql_busca_pergunta = "select * from public.perguntas_doutrinaeconvenios where nivel = ?";
		else if(escritura.equals("velho"))sql_busca_pergunta = "select * from public.perguntas_velhotestamento where nivel = ?";
		else if(escritura.equals("novo"))sql_busca_pergunta = "select * from public.perguntas_novotestamento where nivel = ?";
		
		ResultSet resultado;
		List<Pergunta> listaDePerguntas = new ArrayList<Pergunta>();
		Pergunta perguntaSelecionada;
		try{
			if(con.isClosed()){
				con = ConnectionFactoryDAO.criaConexao();
			}
			PreparedStatement ps = con.prepareStatement(sql_busca_pergunta);
			ps.setInt(1, nivel);
			resultado = ps.executeQuery();
			
			while(resultado.next()){
				perguntaSelecionada = new Pergunta();
				perguntaSelecionada.setIdPergunta(resultado.getInt(1));
				perguntaSelecionada.setNivel(resultado.getInt(2));
				perguntaSelecionada.setPergunta(resultado.getString(3));
				perguntaSelecionada.setResposta(resultado.getInt(4));
				perguntaSelecionada.setAlternativa_A(resultado.getString(5));
				perguntaSelecionada.setAlternativa_B(resultado.getString(6));
				perguntaSelecionada.setAlternativa_C(resultado.getString(7));
				perguntaSelecionada.setAlternativa_D(resultado.getString(8));
				listaDePerguntas.add(perguntaSelecionada);
			}
			
		}catch(Exception e){
			System.out.println("Erro ao selecionar dados".concat(e.getMessage()));
		}
		return listaDePerguntas;
	}

	@Override
	public Boolean cadastraPergunta(Pergunta pergunta) {
		Boolean status = false;
		try{
			if(con.isClosed()){
				con = ConnectionFactoryDAO.criaConexao();
			}
			PreparedStatement ps = con.prepareStatement(CADASTRA_PERGUNTA);
			ps.setInt(1, pergunta.getNivel());
			ps.setString(2, pergunta.getPergunta());
			ps.setInt(3, pergunta.getResposta());
			ps.setString(4, pergunta.getAlternativa_A());
			ps.setString(5, pergunta.getAlternativa_B());
			ps.setString(6, pergunta.getAlternativa_C());
			ps.setString(7, pergunta.getAlternativa_D());
			ps.execute();
			status = true;
			System.out.println("Cadastrado com sucesso");
			
		}catch(Exception e){
			System.out.println("Falha ao cadatrar pergunta");
			status = false;
		}	
		return status;
	}

}
