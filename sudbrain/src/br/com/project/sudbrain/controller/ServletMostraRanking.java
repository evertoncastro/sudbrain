package br.com.project.sudbrain.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.project.sudbrain.model.dao.DataPontuacaoDAO;
import br.com.project.sudbrain.model.vo.Pontuacao;

public class ServletMostraRanking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public String escrituraEscolhida = null;
    
    public ServletMostraRanking() {
        super();      
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String escritura = request.getParameter("escritura");
		List<Pontuacao> lista = new ArrayList<Pontuacao>();
		DataPontuacaoDAO dataPontuacaoDAO = new DataPontuacaoDAO();		
		lista = dataPontuacaoDAO.buscaPontuacao(verificaEscritura(escritura));		
		
		request.setAttribute("lista", lista);
		request.setAttribute("escrituraEscolhida", escrituraEscolhida);
		RequestDispatcher proximaPagina = request.getRequestDispatcher("ranking.jsp");
		proximaPagina.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public int verificaEscritura(String escritura){
		int retorno = 0;
		if(escritura.equals("mormon")){
			this.escrituraEscolhida="Livro de M�rmon"; retorno=1;
		}else if(escritura.equals("doutrina")){
			this.escrituraEscolhida="Doutrina e Conv�nios"; retorno=2;
		}else if(escritura.equals("velho")){
			this.escrituraEscolhida="Velho Testamento"; retorno=3;
		}else if(escritura.equals("novo")){
			this.escrituraEscolhida="Novo Testamento"; retorno=4;
		}
		return retorno;
	}

}
