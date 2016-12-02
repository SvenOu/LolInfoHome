package com.svenou.myapp.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.svenou.myapp.commom.bean.CommonResponse;
import com.svenou.myapp.commom.bean.DataPackage;
import com.svenou.myapp.main.dao.ContactDAO;
import com.svenou.myapp.main.model.Contact;
import com.svenou.myapp.main.service.ContactService;
import org.springframework.stereotype.Service;

public class ContactServiceImpl implements ContactService {

	@Autowired ContactDAO contactDAO;
	@Override
	public CommonResponse saveContact(Contact contact) {
		int result = contactDAO.saveOrUpdate(contact);
		if(result>0)
			return CommonResponse.SIMPLE_SUCCESS;
		else
			return CommonResponse.SIMPLE_FAILURE;
	}

	@Override
	public CommonResponse deleteContact(int contactId) {
		int result = contactDAO.delete(contactId);
		if(result>0)
			return CommonResponse.SIMPLE_SUCCESS;
		else
			return CommonResponse.SIMPLE_FAILURE;
		
	}

	@Override
	public CommonResponse getContact(int contactId) {
		Contact contact = contactDAO.get(contactId);
		if(null != contact)
			return CommonResponse.success(contact);
		else 
			return CommonResponse.SIMPLE_FAILURE;
	}

	@Override
	public DataPackage<Contact> getContactList() {
		List<Contact> contactList = contactDAO.list();
		return new DataPackage<Contact>(contactList);	
	}

}
