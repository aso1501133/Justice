package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ObentoDAO;
import dao.VotesDAO;
import model.Obento;
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

		ObentoDAO obentoDao = new ObentoDAO();
		Obento ob = new Obento();
		VotesDAO votesDAO = new VotesDAO();
		Votes vo = new Votes();

		request.setAttribute("obentoRanking",obentoDao.getObentoRanking());
		//▼▼▼中身確認▼▼▼
		  List<Obento> lit = obentoDao.getObentoRanking();
		  for(Obento lit2 : lit){
		  System.out.println("順位"+lit2.getBento_name());
		  }

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G301.jsp");
		rd.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
