package com.svenou.myapp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svenou.myapp.commom.bean.CommonResponse;
import com.svenou.myapp.commom.bean.DataPackage;
import com.svenou.myapp.main.model.Contact;
import com.svenou.myapp.main.service.ContactService;

@Controller
@RequestMapping(value = "/main")
public class HomeController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/")
	public @ResponseBody
	DataPackage<Contact> listContact() {
		DataPackage<Contact> listContact = contactService.getContactList();
		return listContact;
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.GET)
	public CommonResponse saveContact(Contact newContact) {
		return contactService.saveContact(newContact);
	}

	@RequestMapping(value = "/getContact", method = RequestMethod.GET)
	public CommonResponse getContact(int contactId) {
		return contactService.getContact(contactId);
	}
}
