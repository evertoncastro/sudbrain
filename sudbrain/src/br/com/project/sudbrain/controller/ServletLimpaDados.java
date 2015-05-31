package br.com.project.sudbrain.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletLimpaDados.do")
public class ServletLimpaDados extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
    public ServletLimpaDados() {
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
		int impedeAtualizacao = (int) sessao.getAttribute("impedeAtualizacao");
		impedeAtualizacao=1;
		sessao.setAttribute("impedeAtualizacao", impedeAtualizacao);
		
		RequestDispatcher view = request.getRequestDispatcher("/jogar.jsp");
		view.forward(request, response);
	}

}
