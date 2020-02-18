package cn.superman.web.constant;

public enum MailConstant {
	userName("1010992686@qq.com"), password("yntzjsitdtwnbfeg"), host(
			"smtp.qq.com");
	private String value;

	private MailConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
