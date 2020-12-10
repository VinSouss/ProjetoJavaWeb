package br.com.acme.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.service.ContatoService;
import br.com.acme.agenda.service.ContatoServiceImpl;
import br.com.acme.agenda.dao.ContatoDaoImpl;



/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoService service;
	private ContatoDaoImpl contatoDao;
	public LoginControllerServlet() {

		this.service = new ContatoServiceImpl();
		this.contatoDao = new ContatoDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contatoDao.adicionarUsuario();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		
		
		if (contatoDao.login(login, senha)) {
			RequestDispatcher rd = request.getRequestDispatcher("lista_contatos.jsp");
			rd.forward(request, response);

			response.sendRedirect("lista_contatos.jsp");
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}	
	}

}
