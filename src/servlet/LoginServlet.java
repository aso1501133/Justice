package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ObentoDAO;
import dao.UserDAO;
import model.Obento;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");

		// 確認
		System.out.println(user_id);
		System.out.println(password);

		// ▼▼ログイン用処理▼▼
		UserDAO userDao = new UserDAO();
		User us = new User();

		ObentoDAO obentoDao = new ObentoDAO();
		Obento ob = new Obento();

		obentoDao.selectAllObento();

		// ログインユーザー情報を探す
		us = userDao.selectLoginUser(user_id, password);

		String cnt_user = userDao.CountUser();
		String voted_user = userDao.CountVotedUser();
		HttpSession session = request.getSession();

		// ログイン処理
		String path = "";
		if (cnt_user != voted_user) {
			path = "WEB-INF/jsp/G102.jsp";
			// セッションスコープにログインユーザー情報を保存
			session.setAttribute("loginUser", us.getUser_id());
			session.setAttribute("loginUser", us.getVote());
		} else if (cnt_user.equals(voted_user)) {
			path = "kadai3/Ranking";
			// セッションスコープにログインユーザー情報を保存
			session.setAttribute("loginUser", us.getUser_id());
			/*
			 * //▼▼▼中身確認▼▼▼ List<Schedule> lit =
			 * scheduleDAO.selectSchedule(userID); for(Schedule lit2 : lit){
			 * System.out.println(lit2.getWeek());
			 * System.out.println(lit2.getPlan()); }
			 */

			// ログイン処理
			String path = "";
			if (us != null && us.getVote().equals("0")) { // 未投票ならG202に遷移
				path = "WEB-INF/jsp/102.jsp";
				// セッションスコープにログインユーザー情報を保存
				session.setAttribute("loginUser", us.getUser_id());
				session.setAttribute("loginUser", us.getVote());
			} else if (us != null && us.getVote().equals("1")) { // 投票済ならG201に遷移
				// セッションスコープにログインユーザー情報を保存
				session.setAttribute("loginUser", us.getUser_id());
				session.setAttribute("loginUser", us.getVote());
				/*
				 * //▼▼▼中身確認▼▼▼ List<Schedule> lit =
				 * scheduleDAO.selectSchedule(userID); for(Schedule lit2 : lit){
				 * System.out.println(lit2.getWeek());
				 * System.out.println(lit2.getPlan()); }
				 */

			} else { // 不一致なら
				request.setAttribute("alart", " no");
				path = "WEB-INF/index.jsp";
=======
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
			/**
			 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
>>>>>>> branch 'master' of https://github.com/aso1501133/Justice.git
			}
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

<<<<<<< HEAD
			path = "WEB-INF/jsp/G101.jsp";
		} else { // 不一致なら
			request.setAttribute("alart", " no");
			path = "WEB-INF/index.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
=======
			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				//doGet(request, response);
				// リクエストパラメータの取得
						request.setCharacterEncoding("UTF-8");
						String user_id = request.getParameter("user_id");
						String password = request.getParameter("password");

						// 確認
						System.out.println(user_id);
						System.out.println(password);

						// ▼▼ログイン用処理▼▼
						UserDAO userDao = new UserDAO();
						User us = new User();

						ObentoDAO obentoDao = new ObentoDAO();
						Obento ob = new Obento();

						// ログインユーザー情報を探す
						us = userDao.selectLoginUser(user_id, password);

						String cnt_user = userDao.CountUser();
						String voted_user = userDao.CountVotedUser();
						HttpSession session = request.getSession();

						// ログイン処理
						String path = "";
						if (us != null && us.getVote().equals("0")) { // 未投票ならG102に遷移
							path = "WEB-INF/jsp/G102.jsp";
							// セッションスコープにログインユーザー情報を保存
							session.setAttribute("loginUser", us.getUser_id());
							session.setAttribute("voted", us.getVote());

							request.setAttribute("obentoList",obentoDao.selectAllObento());

							  //▼▼▼中身確認▼▼▼
							  List<Obento> lit = obentoDao.selectAllObento();
							  for(Obento lit2 : lit){
							  System.out.println(lit2.getBento_id());
							  System.out.println(lit2.getBento_name());
							  System.out.println(lit2.getImage());
							  }
						} else if (us != null && us.getVote().equals("1")) { // 投票済ならG201に遷移
							// セッションスコープにログインユーザー情報を保存
							session.setAttribute("loginUser", us.getUser_id());
							session.setAttribute("loginUser", us.getVote());
							path = "WEB-INF/jsp/G101.jsp";
						} else { // 不一致なら
							request.setAttribute("alart"," no");
							path = "WEB-INF/index.jsp";
						}
						RequestDispatcher rd = request.getRequestDispatcher(path);
						rd.forward(request, response);
					}
>>>>>>> branch 'master' of https://github.com/aso1501133/Justice.git
	}

}
