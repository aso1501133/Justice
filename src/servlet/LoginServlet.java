/*
 * date:2017/05/12
 * name:福永利恵
 * comm:ログイン用サーブレット
 */

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
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");

		// 確認
		System.out.println(user_id);
		System.out.println(password);

		// ▼▼ログイン用処理▼▼
		UserDAO userDAO = new UserDAO();
		User us = new User();

		// ログインユーザー情報を探す
		us = userDAO.selectLoginUser(user_id, password);

		String cnt_user = userDAO.CountUser();
		String voted_user = userDAO.CountVotedUser();
		HttpSession session = request.getSession();

		// ログイン処理
		String path = "";
		if (us != null && us.getVote().equals("0")) { // 未投票ならG202に遷移
			path = "WEB-INF/jsp/G202.jsp";
			// セッションスコープにログインユーザー情報を保存
			session.setAttribute("loginUser", us.getUser_id());
			session.setAttribute("loginUser", us.getVote());
		} else if (us != null && us.getVote().equals("1")) { // 投票済ならG201に遷移
			// セッションスコープにログインユーザー情報を保存
			session.setAttribute("loginUser", us.getUser_id());
			session.setAttribute("loginUser", us.getVote());
			/*
			 * //▼▼▼中身確認▼▼▼
			 * List<Schedule> lit = scheduleDAO.selectSchedule(userID);
			 * for(Schedule lit2 : lit){
			 * System.out.println(lit2.getWeek());
			 * System.out.println(lit2.getPlan());
			 * }
			 */

			path = "WEB-INF/jsp/G201.jsp";
		} else { // 不一致なら
			request.setAttribute("alart"," no");
			path = "WEB-INF/index.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}