package com.nostra13.universalimageloader.sample.api.model;

public class Product {
	private String url;
	private String title;
	private String desc;
	
	public Product(String url, String title, String desc) {
		this.url = url;
		this.title = title;
		this.desc = desc;
	}
	public String getImageUrl() {
		return url;
	}
	public void setImageUrl(String url) {
		this.url = url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return title + "\n" + desc;
	}	
}