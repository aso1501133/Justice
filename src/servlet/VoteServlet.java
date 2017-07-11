package servlet;

import java.io.IOException;

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
 * Servlet implementation class VoteServlet
 */
@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");

		System.out.println("bento_id:" + request.getParameter("bento_id"));
		String bento_id = request.getParameter("bento_id");
		ObentoDAO obentoDao = new ObentoDAO();
		Obento obento = new Obento();
		VotesDAO votesDao = new VotesDAO();
		Votes votes = new Votes();

		votesDao.selectVotes(bento_id);
		int nowvotes = Integer.parseInt(votes.getVotes());
		int newvotes = nowvotes + 1 ;
		System.out.println(newvotes);

		votesDao.setVote(bento_id,newvotes);
	}

}
