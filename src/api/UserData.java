package api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserData {
	public String name;
	public String pass;

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}
}