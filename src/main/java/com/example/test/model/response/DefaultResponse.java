package com.example.test.model.response;

import lombok.Data;

/**
 * describe:
 *
 * @author sc
 * @date 2020/06/06
 */
@Data
public class DefaultResponse {

	private Integer code;
	private boolean success;
	private String message;
	private Object data;

	public DefaultResponse() {
	}

	public void success(Object data) {
		this.code = 200;
		this.success = true;
		this.data = data;
	}

	public void fail(Integer code, String message) {
		this.code = code;
		this.success = false;
		this.message = message;
	}

}
