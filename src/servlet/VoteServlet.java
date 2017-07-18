package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ObentoDAO;
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

		System.out.println("投票した弁当"+bento_id);
		System.out.println("投票したコメント"+comment);

		VotesDAO votesDao = new VotesDAO();
		Votes vo = new Votes();

		UserDAO userDao = new UserDAO();
		User us = new User();

		ObentoDAO obentoDao = new ObentoDAO();

		String user_id = (String) session.getAttribute("loginUser");
		System.out.println("session:"+user_id);

		//ログインしているユーザーの投票権を１（投票済）に更新
		userDao.UpdateVote(user_id);
		session.setAttribute("votes", us.getVote());

		System.out.println("kakunin:"+bento_id);
		//お弁当テーブルの票数を1票追加
		int now_vote = Integer.parseInt(obentoDao.getObentoVotes(bento_id));
		System.out.println("now_vote:"+now_vote);

		int new_vote = now_vote + 1 ;
		System.out.println("新しい票数："+new_vote);
		obentoDao.updateObentoVotes(bento_id,new_vote);
		votesDao.insertComment(bento_id,user_id,comment);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G105.jsp");
		rd.forward(request, response);
	}

}
