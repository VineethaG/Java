package com.model;

public class Product {
	private int id;
	private String desc;
	private String name;
	private int price;
	private String url;
	
	public Product() {
		 
	   }
	 
	public Product(String desc, String name, int price, String url) {
		super();
		this.desc = desc;
		this.name = name;
		this.price = price;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
