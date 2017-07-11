package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VotesDAO;
import model.Votes;

/**
 * Servlet implementation class Ranking
 */
@WebServlet("/Ranking")
public class Ranking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VotesDAO votesDAO = new VotesDAO();
		ArrayList<Votes> votes = votesDAO.getRanking();
		request.setAttribute("votes", votes);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G301.jsp");
		rd.forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
