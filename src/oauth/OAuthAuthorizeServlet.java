package oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.logic.User;

@WebServlet("/OAuthAuthorizeServlet")
public class OAuthAuthorizeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("loginUser");
		String originalurl = (String) session.getAttribute("originalurl");
		String rstate = (String) session.getAttribute("rstate");

		String url = originalurl + "&" + rstate + "&confirmation=" + user.getPass() + "&username=" + user.getName();

		response.sendRedirect(url);
	}

}
