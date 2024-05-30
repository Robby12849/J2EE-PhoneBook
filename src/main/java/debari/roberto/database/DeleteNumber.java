package debari.roberto.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import debari.roberto.database.dao.DaoAccessNumero;

/**
 * Servlet implementation class DeleteNumber
 */
@WebServlet("/deletenumber")
public class DeleteNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		DaoAccessNumero dao=new DaoAccessNumero();
		dao.deletenumber(id);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Contatto eliminato con successo!');window.location.href='selectallnumber';</script>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
