package com.marlabs.struts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "details001")
public class Mybean 
{	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int no;
	
	@Column
	private String nam="";
	
	@Column
	private String ct="";
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}		
	
	
	
}
