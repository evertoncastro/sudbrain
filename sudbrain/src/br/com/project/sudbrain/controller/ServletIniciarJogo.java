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

import br.com.project.sudbrain.model.dao.DataPerguntaDAO;
import br.com.project.sudbrain.model.help.Ajuda;
import br.com.project.sudbrain.model.help.Sorteio;
import br.com.project.sudbrain.model.help.UtilizaSorteio;
import br.com.project.sudbrain.model.vo.Acao;
import br.com.project.sudbrain.model.vo.Pergunta;
import br.com.project.sudbrain.model.vo.Usuario;


@WebServlet("/servletIniciarJogo.do")
public class ServletIniciarJogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletIniciarJogo() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		int impedeAtualizacao = (int) sessao.getAttribute("impedeAtualizacao");
		if(impedeAtualizacao>1){
									
			RequestDispatcher view = request.getRequestDispatcher("servletLimpaDados.do");
			view.forward(request, response);
		}else{
			//Escritura
			String escritura = request.getParameter("escritura");		
			sessao.setAttribute("escritura", escritura);
			if(sessao.getAttribute("usuario")==null){
				response.sendRedirect("index.jsp");
			}else{
				impedeAtualizacao++;
				sessao.setAttribute("impedeAtualizacao", impedeAtualizacao);				
				
				DataPerguntaDAO dataPerguntaDAO = new DataPerguntaDAO();
				List<Pergunta> listaPergunta;
				listaPergunta = dataPerguntaDAO.buscaPerguntaNivel(1, escritura);
				Random gerador = new Random();
				int numeroSorteado =  0;
				
				do{
					numeroSorteado = gerador.nextInt(listaPergunta.size());
				}while(numeroSorteado >= listaPergunta.size());			
				
				Pergunta perguntaSorteada = listaPergunta.get(numeroSorteado);
				sessao.setAttribute("perguntaSorteada", perguntaSorteada);
				
				int numeroEscritura = verificaEscritura(escritura);
				request.setAttribute("numeroEscritura", numeroEscritura);
				sessao.setAttribute("numeroEscritura", numeroEscritura);
				
				Usuario usuario = (Usuario) sessao.getAttribute("usuario");
				request.setAttribute("usuario", usuario);
				request.setAttribute("pergunta", perguntaSorteada);
				
				Acao acao = new Acao();			
				sessao.setAttribute("acao", acao);
				
				Ajuda ajuda = new Ajuda();
				sessao.setAttribute("ajuda", ajuda);
				
				Sorteio sorteio = new Sorteio();
				sorteio = UtilizaSorteio.aposSorteio(sorteio);
				sessao.setAttribute("sorteio", sorteio);
				
				String servletChamada = new String();
				//servletChamada = "servletProximaQuestao.do?nivel="+Math.addExact(perguntaSorteada.getNivel(), 1);
				servletChamada = "servletProximaQuestao.do?nivel="+soma(perguntaSorteada.getNivel(), 1);
				request.setAttribute("servletChamada", servletChamada);
				
				String puloChamado = new String();
				puloChamado = "servletPularQuestao.do?pulo="+acao.getQtdPulo();
				request.setAttribute("puloChamado", puloChamado);
				
				boolean requestEnviadoPelaAcao = false;
				sessao.setAttribute("requestEnviadoPelaAcao", requestEnviadoPelaAcao);
				
				RequestDispatcher view = request.getRequestDispatcher("/play.jsp");
				response.setHeader("play.jsp","no-cache");
				view.forward(request, response); 
		}
		
				
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
