package com.svenou.myapp.main.service;

import com.svenou.myapp.commom.bean.CommonResponse;
import com.svenou.myapp.commom.bean.DataPackage;
import com.svenou.myapp.main.model.Contact;

public interface ContactService {

	public CommonResponse saveContact(Contact contact);
	
	public CommonResponse deleteContact(int contactId);
	
	public CommonResponse getContact(int contactId);
	
	public DataPackage<Contact> getContactList();
}
