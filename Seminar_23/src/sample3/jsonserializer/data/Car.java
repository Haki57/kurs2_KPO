package sample3.jsonserializer.data;

import sample3.jsonserializer.JsonField;

public class Car {

	@JsonField("manufacturer")
	private final String maker;
	
	@JsonField
	private final String model;
	
	private final String year;
	
	public Car(String maker, String model, String year) {
		this.maker = maker;
		this.model = model;
		this.year = year;
	}
	
	public String getMaker() {
		return maker;
	}

	public String getModel() {
		return model;
	}
	
	public String getYear() {
		return year;
	}

	@Override
	public String toString() {
		return year + " " + maker + " " + model;
	}
}
