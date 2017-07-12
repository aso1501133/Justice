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
import model.Obento;

/**
 * Servlet implementation class ShowDetail
 */
@WebServlet("/ShowDetail")
public class ShowDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetail() {
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

		request.setAttribute("obentoDetail",obentoDao.selectObentoDetail(bento_id));
		  //▼▼▼中身確認▼▼▼
		  List<Obento> lit = obentoDao.selectObentoDetail(bento_id);
		  for(Obento lit2 : lit){
		  System.out.println(lit2.getBento_id());
		  System.out.println(lit2.getBento_name());
		  System.out.println(lit2.getImage());
		  }

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G103.jsp");
		rd.forward(request, response);
	}

}
