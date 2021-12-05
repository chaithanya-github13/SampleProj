package com.greenwash.adminpanel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AdminDataBase")
public class AdminPanel {
	public AdminPanel() {
	}
	@Id
	private int adminid;
	private String adminname;
	public AdminPanel(int adminid, String adminname) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	@Override
	public String toString() {
		return "AdminPanel [adminid=" + adminid + ", adminname=" + adminname + "]";
	}
	
}
