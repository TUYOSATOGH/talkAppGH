package api;

public class ApiMutterDataBean {
	private String name;
	private String mutter;
	private String time;

	ApiMutterDataBean(){
		name = null;
		setMutter(null);
		setTime(null);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMutter() {
		return mutter;
	}

	public void setMutter(String mutter) {
		this.mutter = mutter;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
