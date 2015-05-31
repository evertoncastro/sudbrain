package br.com.project.sudbrain.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.project.sudbrain.model.dao.AcaoUtiliza;
import br.com.project.sudbrain.model.help.Sorteio;
import br.com.project.sudbrain.model.help.UtilizaSorteio;
import br.com.project.sudbrain.model.vo.Acao;
import br.com.project.sudbrain.model.vo.Pergunta;


public class ServletSorteio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletSorteio() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Acao acao = (Acao) sessao.getAttribute("acao");
		
		if(acao.getQtdSorteio()<1){			
						
			RequestDispatcher view = request.getRequestDispatcher("servletLimpaDados.do");
			view.forward(request, response);
			
		}else{
			Pergunta perguntaAtual = (Pergunta) sessao.getAttribute("perguntaSorteada");
			int numeroEscritura = (int) sessao.getAttribute("numeroEscritura");
					
			AcaoUtiliza.controlaAcao(acao, "sorteio");
			sessao.setAttribute("acao", acao);		
			
			Sorteio sorteio = new Sorteio();
			sorteio = UtilizaSorteio.realizaSorteio(sorteio, perguntaAtual);
			sessao.setAttribute("sorteio", sorteio);
			
			Integer sorteioUtilizado = 1;
			sessao.setAttribute("sorteioUtilizado", sorteioUtilizado);
			
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
