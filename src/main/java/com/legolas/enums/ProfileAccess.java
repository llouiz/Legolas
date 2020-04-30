package com.legolas.enums;

public enum ProfileAccess {

	ADMINISTRATOR(1, "ROLE_ADMINISTRATOR"), 
	PARTICIPANT(2, "ROLE_PARTICIPANT");

	private int code;
	private String desc;

	private ProfileAccess(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static ProfileAccess toEnum(Integer code) {
		if (code == null) {
			return null;
		}

		for (ProfileAccess pa : ProfileAccess.values()) {
			if (code.equals(pa.getCode())) {
				return pa;
			}
		}

		throw new IllegalArgumentException("Invalid code: " + code);
	}

}
