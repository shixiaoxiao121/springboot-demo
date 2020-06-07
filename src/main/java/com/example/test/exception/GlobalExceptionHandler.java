package com.example.test.exception;

import com.example.test.exception.model.MyException;
import com.example.test.model.response.DefaultResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * describe:
 *
 * @author sc
 * @date 2020/06/06
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

	DefaultResponse defaultResponse = new DefaultResponse();

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public DefaultResponse errorException(Exception ex) {
		log.error(ex);
		defaultResponse.setCode(500);
		defaultResponse.fail(-1, ex.getMessage());
		return defaultResponse;
	}

	@ResponseBody
	@ExceptionHandler(MyException.class)
	public DefaultResponse myException(MyException ex) {
		log.error(ex);
		defaultResponse.fail(ex.getCode(), ex.getMessage());
		return defaultResponse;
	}

}
