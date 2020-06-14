package com.example.test.controller;

import com.example.test.model.response.DefaultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * describe:
 *
 * @author sc
 * @date 2020/06/14
 */
@RestController
@RequestMapping("/message")
public class MessageController {

	@GetMapping("/verification")
	public DefaultResponse getVerificationCode(@RequestParam(value = "phone", required = true) String phone) {

		DefaultResponse response = new DefaultResponse();
		response.setSuccess(true);
		response.setMessage("123456");
		return response;

	}

}
