package app.logic;

public class LoginLogic {

	public boolean execute(User user) {
		LoginDAO dao = new LoginDAO();
		boolean result = dao.execute(user);
		return result;
	}

}
