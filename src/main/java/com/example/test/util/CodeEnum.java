package com.example.test.util;

/**
 * describe:
 *
 * @author sc
 * @date 2020/06/06
 */
public enum CodeEnum {

	CODE_200(200,""),
	Code_400(404,"找不到");

	private CodeEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	private Integer code;
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public Integer getCode() {
		return this.code;
	}

}
