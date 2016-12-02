package com.svenou.myapp.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svenou.myapp.commom.bean.CommonResponse;
import com.svenou.myapp.main.service.ContactService;
import com.svenou.myapp.security.bean.CSUser;
import com.svenou.myapp.security.service.CsService;

@Controller
@RequestMapping(value = "/controller/security")
public class SecurityController {
	private static Log log = LogFactory.getLog(SecurityController.class);
	
	@Autowired
	private ContactService contactService;
	@Autowired
	private CsService csService;
	
	@RequestMapping(value = "/getCurrentUserDetails")
	public  @ResponseBody CommonResponse getCurrentUserDetails(HttpServletRequest request){
		CSUser csUser = csService.getCurrentUserDetails(request);
		if(null != csUser)
			return CommonResponse.success(csUser);
		return CommonResponse.SIMPLE_FAILURE;
	}

	@RequestMapping("/loginEntry")
	public String loginEntry() {
		log.info("Login success. Prepare to redirect url by user role.");
		String redirectUrl = csService.getLoginSuccessUrl();
		log.info("Redirect to url:" + redirectUrl);
		return "redirect:" + redirectUrl;
	}
}
