package com.example.listviewwithimage;

public class ImageItem {
	public String address;
	public String companyName;
	public int image;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public ImageItem(String address, String companyName, int image) {
		this.address = address;
		this.companyName = companyName;
		this.image = image;
	}
	
	
}
