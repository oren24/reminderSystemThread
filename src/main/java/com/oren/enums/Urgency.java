package com.oren.enums;

public enum Urgency {
	NORMAL(1, "Normal"),
	IMPORTANT(2, "Important"),
	Critical(3, "Critical");
	private int urgencyId;
	private String urgencyName;

	Urgency(int urgencyId, String urgencyName) {
		this.urgencyId = urgencyId;
		this.urgencyName = urgencyName;
	}

	public int getUrgencyId() {
		return urgencyId;
	}

	public void setUrgencyId(int urgencyId) {
		this.urgencyId = urgencyId;
	}

	public String getUrgencyName() {
		return urgencyName;
	}

	public void setUrgencyName(String urgencyName) {
		this.urgencyName = urgencyName;
	}
}
