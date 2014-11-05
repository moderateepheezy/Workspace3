package com.example.foodtrip;

public class Restaurant {

		private String name;
		private String address;
		public int image;
		private String type;

		public String getName() {
			return (name);
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return (address);
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getType() {
			return (type);
		}

		public void setType(String types) {
			type = types;
		}
		
		@Override
		//Add Items to ListView
		public String toString() {
			return getName()+ " , " + getAddress()	+ " , " + getType();

		}

		public Restaurant(String name, String address, int image, String type) {
			this.name = name;
			this.address = address;
			this.image = image;
			this.type = type;
		}

		public Restaurant() {
		}

}
