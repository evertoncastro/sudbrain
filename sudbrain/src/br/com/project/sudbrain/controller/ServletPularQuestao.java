package br.com.project.sudbrain.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.project.sudbrain.model.dao.AcaoUtiliza;
import br.com.project.sudbrain.model.dao.DataPerguntaDAO;
import br.com.project.sudbrain.model.help.Ajuda;
import br.com.project.sudbrain.model.help.Sorteio;
import br.com.project.sudbrain.model.help.UtilizaAjuda;
import br.com.project.sudbrain.model.help.UtilizaSorteio;
import br.com.project.sudbrain.model.vo.Acao;
import br.com.project.sudbrain.model.vo.Pergunta;


@WebServlet("/servletPularQuestao.do")
public class ServletPularQuestao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletPularQuestao() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Acao acao = (Acao) sessao.getAttribute("acao");
		int pulo = Integer.parseInt(request.getParameter("pulo"));
				
		if(acao.getQtdPulo()<=0){			
						
			RequestDispatcher view = request.getRequestDispatcher("servletLimpaDados.do");
			view.forward(request, response);
			
		}else{
		Pergunta objetoPerguntaAtual = (Pergunta) sessao.getAttribute("perguntaSorteada");
		
				int nivelPerguntaAnterior = objetoPerguntaAtual.getNivel();		
				String escritura = (String) sessao.getAttribute("escritura");
				
				DataPerguntaDAO dataPerguntaDAO = new DataPerguntaDAO();
				List<Pergunta> listaPergunta;
				listaPergunta = dataPerguntaDAO.buscaPerguntaNivel(nivelPerguntaAnterior, escritura);
				Random gerador = new Random();
				int numeroSorteado =  0;
				
				Pergunta perguntaSorteada = null;
				do{
					
					do{
						numeroSorteado = gerador.nextInt(listaPergunta.size());
					}while(numeroSorteado >= listaPergunta.size());		
					perguntaSorteada = listaPergunta.get(numeroSorteado);
				
				}while(perguntaSorteada.getIdPergunta()==objetoPerguntaAtual.getIdPergunta());		
				sessao.setAttribute("perguntaSorteada", perguntaSorteada);				
				
				AcaoUtiliza.controlaAcao(acao, "pulo");		
				sessao.setAttribute("acao",  acao);	
				
				Ajuda ajuda = (Ajuda) sessao.getAttribute("ajuda");
				UtilizaAjuda.abreFechaJanelaAjuda(ajuda, false);
				sessao.setAttribute("ajuda", ajuda);
				
				Sorteio sorteio = new Sorteio();
				sorteio = UtilizaSorteio.aposSorteio(sorteio);
				sessao.setAttribute("sorteio", sorteio);
				
				String servletChamada = new String();
				//servletChamada = "servletProximaQuestao.do?nivel="+Math.addExact(perguntaSorteada.getNivel(), 1);
				servletChamada = "servletProximaQuestao.do?nivel="+soma(perguntaSorteada.getNivel(), 1);
				request.setAttribute("servletChamada", servletChamada);
				
				int numeroEscritura = verificaEscritura(escritura);
				request.setAttribute("numeroEscritura", numeroEscritura);
				request.setAttribute("pergunta", perguntaSorteada);
				RequestDispatcher view = request.getRequestDispatcher("/play.jsp");
				view.forward(request, response);
		}
		
	}	
	
	public int verificaEscritura(String escritura){
		int retorno = 0;
		if(escritura.equals("mormon")) retorno=1;
		else if(escritura.equals("doutrina")) retorno=2;
		else if(escritura.equals("velho")) retorno=3;
		else if(escritura.equals("novo")) retorno=4;
		return retorno;
	}
	
	public Integer soma(Integer a, Integer b){
		return a + b;
	}

}
