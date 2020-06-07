package com.example.test.controller;

import com.example.test.model.AccountLogin;
import com.example.test.model.response.DefaultResponse;
import com.example.test.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * describe:
 *
 * @author sc
 * @date 2020/06/04
 */

@RestController
@RequestMapping("/account")
@Log4j2
public class AccountController {

	@Resource
	AccountService accountService;

	@GetMapping("/check_username")
	public DefaultResponse checkUsername(@RequestParam(value = "username",required = false) String username){
		return accountService.findAccountInfoByUsername(username);
	}

	@GetMapping("/login")
	public String checkUsername(){
		return "aaaa";
	}
}
