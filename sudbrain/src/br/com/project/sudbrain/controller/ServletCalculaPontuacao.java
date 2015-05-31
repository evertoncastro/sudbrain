package br.com.project.sudbrain.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.project.sudbrain.model.dao.AcaoUtiliza;
import br.com.project.sudbrain.model.dao.DataJogadaDAO;
import br.com.project.sudbrain.model.vo.Acao;
import br.com.project.sudbrain.model.vo.Jogada;
import br.com.project.sudbrain.model.vo.Pergunta;
import br.com.project.sudbrain.model.vo.Usuario;


public class ServletCalculaPontuacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletCalculaPontuacao() {
        super();      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		int impedeAtualizacao = (int) sessao.getAttribute("impedeAtualizacao");
		impedeAtualizacao=1;
		sessao.setAttribute("impedeAtualizacao", impedeAtualizacao);
		
		RequestDispatcher view = request.getRequestDispatcher("/jogar.jsp");
		view.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Acao acao = (Acao) sessao.getAttribute("acao");
		
		Pergunta objetoPerguntaAtual = (Pergunta) sessao.getAttribute("perguntaSorteada");
		int ultimaPergunta = objetoPerguntaAtual.getNivel() - 1;
		int pontuacaoRealizada=0;
		if(ultimaPergunta!=0){
			pontuacaoRealizada = (ultimaPergunta * 10) + AcaoUtiliza.verificaAcaoUtilizada(acao);
		}
		
		Usuario usuarioSessao = (Usuario) sessao.getAttribute("usuario");
		String escrituraUtilizada = (String) sessao.getAttribute("escritura");		
		
		Jogada jogada = new Jogada();
		jogada.setId_usuario(usuarioSessao.getId());
		jogada.setPontos(pontuacaoRealizada);
		try{
			jogada.setId_escritura(verificaEscritura(escrituraUtilizada));
			
		}catch(Exception e){
			System.out.println("Problema na convers�o da string escritura para Integer");
		}
		
		DataJogadaDAO dataJogadaDAO = new DataJogadaDAO();		
		boolean statusInsercao = false;		
		statusInsercao = dataJogadaDAO.insereJogada(jogada);
		if(statusInsercao) System.out.println("Jogada registrada com sucesso");
		
		String mensagem = null;
		String mensagemPontos = null;
		
		mensagem = "Jogo encerrado";
		mensagemPontos = "Pontua��o realizada: "+pontuacaoRealizada;
		
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("mensagemPontos", mensagemPontos);
		RequestDispatcher proximaPagina = request.getRequestDispatcher("jogar.jsp");
		proximaPagina.forward(request, response);
	}
	
	public int verificaEscritura(String escritura){
		int retorno = 0;
		if(escritura.equals("mormon")) retorno=1;
		else if(escritura.equals("doutrina")) retorno=2;
		else if(escritura.equals("velho")) retorno=3;
		else if(escritura.equals("novo")) retorno=4;
		return retorno;
	}

}
