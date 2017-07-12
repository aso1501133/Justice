package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.VotesDAO;
import model.User;
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
		//セッションの取得
		HttpSession session = request.getSession();

		String bento_id = request.getParameter("bento_id");
		String comment = request.getParameter("comment");

		VotesDAO votesDao = new VotesDAO();
		Votes vo = new Votes();

		UserDAO userDao = new UserDAO();
		User us = new User();

		String user_id = (String) session.getAttribute("loginUser");
		System.out.println("session:"+user_id);

		//ログインしているユーザーの投票権を１（投票済）に更新
		userDao.UpdateVote(user_id);
		session.setAttribute("votes", us.getVote());

		votesDao.addVotes(bento_id, comment);
		//↑のSQLではbento_id1票ごとに1件の列が挿入されます。最終的な票の集計をするときはvotesが１の列が何件あるか集計するSQLをつくること

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G105.jsp");
		rd.forward(request, response);
	}

}
