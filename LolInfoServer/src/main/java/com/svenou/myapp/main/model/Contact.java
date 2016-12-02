package com.svenou.myapp.main.model;

import java.io.Serializable;

public class Contact implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contactId;
	private String name;
	private String email;
	private String address;
	private String telephone;
	
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Contact(int contactId, String name, String email, String address,
			String telephone) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
	}

	/**
	 * @return the contactId
	 */
	public int getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", name=" + name
				+ ", email=" + email + ", address=" + address + ", telephone="
				+ telephone + "]";
	}

	

	
}
