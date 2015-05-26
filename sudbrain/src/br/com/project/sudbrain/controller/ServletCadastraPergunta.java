package br.com.project.sudbrain.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.project.sudbrain.model.dao.DataPerguntaDAO;
import br.com.project.sudbrain.model.vo.Pergunta;

@WebServlet("/servletCadastraPergunta.do")
public class ServletCadastraPergunta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletCadastraPergunta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer nivel  = Integer.parseInt(request.getParameter("txtNivel"));
		String pergunta  = new String(request.getParameter("txtPergunta").getBytes("ISO-8859-1"), "UTF-8");
		Integer resposta = Integer.parseInt(request.getParameter("txtResposta"));
		String alternativa1 = new String(request.getParameter("txtAlternativa1").getBytes("ISO-8859-1"), "UTF-8");
		String alternativa2 = new String(request.getParameter("txtAlternativa2").getBytes("ISO-8859-1"), "UTF-8");
		String alternativa3 = new String(request.getParameter("txtAlternativa3").getBytes("ISO-8859-1"), "UTF-8");
		String alternativa4 = new String(request.getParameter("txtAlternativa4").getBytes("ISO-8859-1"), "UTF-8");
		
		Pergunta perguntaObjeto = new Pergunta();
		perguntaObjeto.setNivel(nivel);
		perguntaObjeto.setPergunta(pergunta);
		perguntaObjeto.setResposta(resposta);
		perguntaObjeto.setAlternativa_A(alternativa1);
		perguntaObjeto.setAlternativa_B(alternativa2);
		perguntaObjeto.setAlternativa_C(alternativa3);
		perguntaObjeto.setAlternativa_D(alternativa4);
		
		Boolean status = false;
		DataPerguntaDAO dataPerguntaDAO = new DataPerguntaDAO();
		status = dataPerguntaDAO.cadastraPergunta(perguntaObjeto);
		
		String mensagem = null;
		if(status){
			mensagem = "Pergunta cadastrada com sucesso";
		}else{
			mensagem = "Pergunta não cadastrada";
		}
		
		request.setAttribute("mensagem", mensagem);		
		RequestDispatcher proximaPagina = request.getRequestDispatcher("cadastro_perguntas.jsp");
		proximaPagina.forward(request, response);
		
	}

}
