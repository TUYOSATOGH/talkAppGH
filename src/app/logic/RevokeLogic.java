package app.logic;

public class RevokeLogic {

	public boolean execute(User user) {
		RevokeDAO dao = new RevokeDAO();
		boolean result = dao.execute(user);
		return result;
	}

}
