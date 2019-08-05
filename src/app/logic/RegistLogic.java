package app.logic;

public class RegistLogic {

	public boolean execute(User user) {
		RegistDAO dao = new RegistDAO();
		boolean result = dao.execute(user);
		return result;
	}

}
