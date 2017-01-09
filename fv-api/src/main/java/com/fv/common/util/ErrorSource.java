package com.fv.common.util;

public enum ErrorSource {

	CLIENT("client"),
	SERVER("server");
	private final String value;

	ErrorSource(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static ErrorSource fromValue(String v) {
		for (ErrorSource c: ErrorSource.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}

