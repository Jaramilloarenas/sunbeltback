package com.jararenas.pruebasunbelt.models;

public class Customer {
	
	private String typeDoc;
	private String document;
	private String firstName;
	private String secondName;
	private String surname;
	private String secondSurname;
	private String telephone;
	private String address;
	private String city;
	
	public String getTypeDoc() {
		return typeDoc;
	}
	public String getDocument() {
		return document;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public String getSurname() {
		return surname;
	}
	public String getSecondSurname() {
		return secondSurname;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public void setTypeDoc(String typeDoc) {
		this.typeDoc = typeDoc;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Customer() {

	}
	
	public Customer(String type, String doc) {
		this.typeDoc = type;
		this.document = doc;
	}
	
	@Override
	public String toString() {
		return "Customer [typeDoc=" + typeDoc + ", document=" + document + ", firstName=" + firstName + ", secondName="
				+ secondName + ", surname=" + surname + ", secondSurname=" + secondSurname + ", telephone=" + telephone
				+ ", address=" + address + ", city=" + city + "]";
	}
	
	
	
	
}
