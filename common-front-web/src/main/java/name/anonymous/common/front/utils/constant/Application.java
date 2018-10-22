package name.anonymous.common.front.utils.constant;

public enum Application {
	HEROS("heros");

	private String tehnicalUrlName;
	private Application(String tehnicalUrlName) {
		this.tehnicalUrlName = tehnicalUrlName;
	}
	public String toTechnicalUrlName() {
		return tehnicalUrlName;
	}
	public String toMessageSourcePrefix() {
		return tehnicalUrlName + ".";
	}
}
