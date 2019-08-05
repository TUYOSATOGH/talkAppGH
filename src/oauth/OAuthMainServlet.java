package oauth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OAuthMainServlet")
public class OAuthMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String originalurl = request.getParameter("original-url");
		String rstate = request.getParameter("rstate");
		HttpSession session = request.getSession();
		session.setAttribute("originalurl", originalurl);
		session.setAttribute("rstate", rstate);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/oauth/oauthmain.jsp");
		dispatcher.forward(request, response);
	}

}
