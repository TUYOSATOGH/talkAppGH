package api;

public class ApiUserDataBean {
	private String name;
	private String pass;
	private String jotai;

	ApiUserDataBean(){
		name = null;
		pass = null;
		jotai = null;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getJotai() {
		return jotai;
	}
	public void setJotai(String jotai) {
		this.jotai = jotai;
	}

}
