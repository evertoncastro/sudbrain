package br.com.project.sudbrain.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.project.sudbrain.model.dao.AcaoUtiliza;
import br.com.project.sudbrain.model.help.Ajuda;
import br.com.project.sudbrain.model.help.UtilizaAjuda;
import br.com.project.sudbrain.model.vo.Acao;
import br.com.project.sudbrain.model.vo.Pergunta;

@WebServlet("/servletAjuda.do")
public class ServletAjuda extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Variaveis globias utilizadas para a definicao dos valores das ajudas
	
    public ServletAjuda() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Acao acao = (Acao) sessao.getAttribute("acao");
		
		if(acao.getQtdAjuda()<1){			
						
			RequestDispatcher view = request.getRequestDispatcher("servletLimpaDados.do");
			view.forward(request, response);
			
		}else{
			Pergunta perguntaAtual = (Pergunta) sessao.getAttribute("perguntaSorteada");
			int numeroEscritura = (int) sessao.getAttribute("numeroEscritura");
			
			
			AcaoUtiliza.controlaAcao(acao, "ajuda");
			sessao.setAttribute("acao", acao);		
			
			Ajuda ajuda = new Ajuda();
			UtilizaAjuda utilizaAjuda = new UtilizaAjuda();
			ajuda = utilizaAjuda.defineAlternativa(ajuda, perguntaAtual);
			UtilizaAjuda.abreFechaJanelaAjuda(ajuda, true);
			sessao.setAttribute("ajuda", ajuda);
			
			String servletChamada = new String();
			//servletChamada = "servletProximaQuestao.do?nivel="+Math.addExact(perguntaAtual.getNivel(), 1);
			servletChamada = "servletProximaQuestao.do?nivel="+soma(perguntaAtual.getNivel(), 1);
			request.setAttribute("servletChamada", servletChamada);
			
			String puloChamado = new String();
			puloChamado = "servletPularQuestao.do?pulo="+acao.getQtdPulo();
			request.setAttribute("puloChamado", puloChamado);
			
			request.setAttribute("pergunta", perguntaAtual);		
			request.setAttribute("numeroEscritura", numeroEscritura);
			RequestDispatcher view = request.getRequestDispatcher("/play.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public Integer soma(Integer a, Integer b){
		return a + b;
	}
	
	

}
