package br.com.project.sudbrain.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.project.sudbrain.model.dao.DataUsuarioDAO;
import br.com.project.sudbrain.model.vo.Usuario;


@WebServlet("/servletLogin.do")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletLogin() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("acao")!=null){
			if(request.getParameter("acao").equals("sair")){
				HttpSession sessao = request.getSession();
				sessao.invalidate();
				boolean logado = false;
				request.setAttribute("logado", logado);
				response.sendRedirect("index.jsp");
				System.out.println("Deslogado");
			}
		}			
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String senha = request.getParameter("txtSenha");
		
		Cookie ck = new Cookie("login", login);
		ck.setMaxAge(60*60*24*3);
		response.addCookie(ck);		
				
		DataUsuarioDAO dataUsuarioDAO = new DataUsuarioDAO();
		Usuario usuario = dataUsuarioDAO.buscaUsuario(login, senha);		
		
		if(usuario==null){
			String statusLogin = "Login e/ou senha incorretos";
			request.setAttribute("statusLogin", statusLogin);
			RequestDispatcher telaUsuarioLogado = request.getRequestDispatcher("/index.jsp");
			telaUsuarioLogado.forward(request, response);
		}else if(usuario!=null && (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha))){
			HttpSession sessao = request.getSession();
			boolean logado = true;
			int impedeAtualizacao = 1;
			sessao.setAttribute("logado", logado);
			sessao.setAttribute("usuario", usuario);
			sessao.setAttribute("impedeAtualizacao", impedeAtualizacao);
			RequestDispatcher telaUsuarioLogado = request.getRequestDispatcher("/index.jsp");
			telaUsuarioLogado.forward(request, response);
		}
	
	}

}
