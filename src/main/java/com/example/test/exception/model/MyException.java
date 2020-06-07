package com.example.test.exception.model;

import com.example.test.util.CodeEnum;
import lombok.Data;

/**
 * describe:
 *
 * @author sc
 * @date 2020/06/06
 */
@Data
public class MyException extends RuntimeException{

	private Integer code;
	private String message;

	public MyException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public MyException(CodeEnum codeEnum) {
		this.code = codeEnum.getCode();
		this.message = codeEnum.getMessage();
	}

}
