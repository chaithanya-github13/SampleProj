package com.greenWash.Customer.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CustomerData")
public class Customer {
	
	
	public Customer() {
		
	}
	@Id
	private int customerid;
	private String customername;
	private long mobilenumber;
	private String carmodel;
	public Customer(int customerid, String customername, long mobilenumber, String carmodel) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.mobilenumber = mobilenumber;
		this.carmodel = carmodel;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", mobilenumber="
				+ mobilenumber + ", carmodel=" + carmodel + "]";
	}
}
	