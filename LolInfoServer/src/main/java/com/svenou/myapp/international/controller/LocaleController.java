package com.svenou.myapp.international.controller;

import com.svenou.myapp.commom.bean.CommonResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME;

@Controller
@RequestMapping("/controller/locale")
public class LocaleController {
	private static final Log log = LogFactory.getLog(LocaleController.class);

	private String defaultMessagesVarName = "AppLocaleMessages";



	@RequestMapping(path = "/messages.js", method = RequestMethod.GET)
	public String getMessages(HttpServletRequest request) {
		String messagesVarNameShortand = request
				.getParameter("messagesVarNameShortand");
		if ((messagesVarNameShortand == null)|| (messagesVarNameShortand.trim().equals("")))
			request.setAttribute("messagesVarNameShortand",this.defaultMessagesVarName);
		else {
			request.setAttribute("messagesVarNameShortand",messagesVarNameShortand);
		}
		return "messages";
	}


	@ResponseBody
	@RequestMapping(path = "/changeLocale", method = RequestMethod.GET)
	public CommonResponse changeLocale(HttpServletRequest request,
									   String locale) {

		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale resolveLocale = localeResolver.resolveLocale(request);
		log.info("country = " + resolveLocale.getDisplayCountry() + ", language = "
				+ resolveLocale.getDisplayLanguage());
		log.info("locale changed to: " + resolveLocale);

		Map data = new HashMap(1);
		data.put("locale", resolveLocale);

		return CommonResponse.success(data);
	}

	public String getDefaultMessagesVarName() {
		return this.defaultMessagesVarName;
	}

	public void setDefaultMessagesVarName(String defaultMessagesVarName) {
		this.defaultMessagesVarName = defaultMessagesVarName;
	}
}