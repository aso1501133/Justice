package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ObentoDAO;
import model.Obento;

/**
 * Servlet implementation class ConfirmVote
 */
@WebServlet("/ConfirmVote")
public class ConfirmVote extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmVote() {
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
		String comment = request.getParameter("comment");

		ObentoDAO obentoDao = new ObentoDAO();
		Obento obento = new Obento();

		request.setAttribute("obentoDetail",obentoDao.selectObentoDetail(bento_id));
		request.setAttribute("comment",comment);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G104.jsp");
		rd.forward(request, response);
	}

}
