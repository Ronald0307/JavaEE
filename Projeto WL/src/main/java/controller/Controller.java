package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;


// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The projeto. */
	JavaBeans projeto = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			pessoas(request, response);
		} else if (action.equals("/insert")) {
			novaPessoas(request, response);
		} else if (action.equals("/select")) {
			listarPessoas(request, response);
		} else if (action.equals("/update")) {
			editarPessoas(request, response);
		} else if (action.equals("/delete")) {
			removerPessoas(request, response);
		} else if (action.equals("/report")) {
			removerPessoas(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Pessoas.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void pessoas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando um objeto que irá receber os dados JavaBeans.
		ArrayList<JavaBeans> lista = dao.listarProjeto();
		// Encaminhar a lista para o documento projeto.jsp
		request.setAttribute("projeto", lista);
		RequestDispatcher rd = request.getRequestDispatcher("projeto.jsp");
		rd.forward(request, response);
	}

	/**
	 * Nova pessoas.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void novaPessoas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		projeto.setNome(request.getParameter("nome"));
		projeto.setCpf(request.getParameter("cpf"));
		projeto.setItem(request.getParameter("item"));
		dao.inserirProjeto(projeto);
		response.sendRedirect("main");
		
	}

	/**
	 * Listar pessoas.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Editar contato
	protected void listarPessoas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		projeto.setIdcon(idcon);
		dao.selecionarProjeto(projeto);
		request.setAttribute("idcon", projeto.getIdcon());
		request.setAttribute("nome", projeto.getNome());
		request.setAttribute("cpf", projeto.getCpf());
		request.setAttribute("item", projeto.getItem());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		;
	}

	/**
	 * Editar pessoas.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarPessoas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		projeto.setIdcon(request.getParameter("idcon"));
		projeto.setNome(request.getParameter("nome"));
		projeto.setCpf(request.getParameter("cpf"));
		projeto.setItem(request.getParameter("item"));
		dao.alterarDados(projeto);
		response.sendRedirect("main");
	}

	/**
	 * Remover pessoas.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerPessoas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		projeto.setIdcon(idcon);
		dao.deletarProjeto(projeto);
		response.sendRedirect("main");
	}

}


