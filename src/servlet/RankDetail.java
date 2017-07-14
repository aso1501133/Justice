/*
 * ランキング詳細（コメント表示なと）を行うためのサーブレット
 *
 */
package servlet;

import java.io.IOException;

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
 * Servlet implementation class RankDetail
 */
@WebServlet("/RankDetail")
public class RankDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RankDetail() {
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
		String bento_id = request.getParameter("bento_id");
		System.out.println("bento_id:" + request.getParameter("bento_id"));

		ObentoDAO obentoDao = new ObentoDAO();
		Obento ob = new Obento();
		VotesDAO votesDao = new VotesDAO();
		Votes vo = new Votes();

		request.setAttribute("obentoDetail",obentoDao.selectObentoDetail(bento_id));
		request.setAttribute("RankDetail",votesDao.selectRankDetail(bento_id));

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G302.jsp");
		rd.forward(request, response);

	}

}
