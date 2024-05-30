package debari.roberto.database;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import debari.roberto.database.dao.DaoAccessNumero;
import debari.roberto.database.pojo.Nome;

@WebServlet("/inseriscinumero")
public class InserisciNumero extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String numero = request.getParameter("numerotelefono");
    	String nome = request.getParameter("nome");
    	String cognome = request.getParameter("cognome");
    	String email = request.getParameter("email");
    	int numero1 = 0;
    	try {
    	    numero1 = Integer.parseInt(numero);
    	} catch (NumberFormatException e) {
    	    e.printStackTrace();
    	}
    	Nome nomec = new Nome(nome, cognome, email,numero1);
    	DaoAccessNumero dao=new DaoAccessNumero();
    	try {
			dao.insertnumero(nomec);
			response.sendRedirect("inseriscinumero.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
