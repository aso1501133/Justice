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
						int voted_users = userDao.CountVotedUser();
						int allUsers = userDao.CountUsers();

						System.out.println("voted_user:"+voted_users);
						System.out.println("allUser:"+allUsers);
						HttpSession session = request.getSession();

						// ログイン処理
						String path = "";
						if (us != null && voted_users != allUsers) { // 全員が未投票ならG102に遷移
							path = "WEB-INF/jsp/G102.jsp";
							// セッションスコープにログインユーザー情報を保存
							session.setAttribute("loginUser", us.getUser_id());
							session.setAttribute("voted", us.getVote());
							request.setAttribute("obentoList",obentoDao.selectAllObento());

						}else if(us != null && voted_users == allUsers){	//全員投票済みならG301に遷移
							System.out.println("全員投票済み");
							path = "WEB-INF/jsp/G301.jsp";
							// セッションスコープにログインユーザー情報を保存
							session.setAttribute("loginUser", us.getUser_id());
							session.setAttribute("voted", us.getVote());
							request.setAttribute("obentoRanking",obentoDao.getObentoRanking());
							//▼▼▼中身確認▼▼▼
							  List<Obento> lit = obentoDao.getObentoRanking();
							  for(Obento lit2 : lit){
							  System.out.println("順位"+lit2.getBento_name());
							  }

						} else { // 不一致なら
							request.setAttribute("alart"," no");
							path = "WEB-INF/index.jsp";
						}
						RequestDispatcher rd = request.getRequestDispatcher(path);
						rd.forward(request, response);
					}
	}

