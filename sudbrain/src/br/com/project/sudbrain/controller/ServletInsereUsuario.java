package br.com.project.sudbrain.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.project.sudbrain.model.dao.DataUsuarioDAO;
import br.com.project.sudbrain.model.vo.Usuario;

@WebServlet("/servletInsereUsuario.do")
public class ServletInsereUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletInsereUsuario() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("txtNome");
		String login = request.getParameter("txtLogin");
		String senha = request.getParameter("txtSenha");
		String email = request.getParameter("txtEmail");
		String mensagem = "";
		
		if(nome.equals("")||login.equals("")||senha.equals("")||email.equals("")){
			response.sendRedirect("novo_jogador.jsp");
		}else{
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setEmail(email);
			boolean statusInsercao = false;
			DataUsuarioDAO dataUsuarioDAO = new DataUsuarioDAO();
			statusInsercao = dataUsuarioDAO.cadastrarUsuario(usuario);
			
			
			if(statusInsercao==true){
				mensagem = "Usuário cadastrado com sucesso";
				
			}else{
				mensagem = "Erro ao cadastrar usuário";
			}
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher proximaTela = request.getRequestDispatcher("/index.jsp");
			proximaTela.forward(request, response);
		}		
	}
}
