package br.com.compassuol.pb.challenge.products.product;

import java.time.LocalDate;
import java.util.Locale.Category;

public class Product {

	private long id;
	private LocalDate date;
	private String description;
	private String name;
	private String imgURL;
	private float price;
	private Category category;

	public Product(long id, LocalDate date, String description, String name, String imgURL, float price, Category category) {
		this.id = id;
		this.date = date;
		this.description = description;
		this.name = name;
		this.imgURL = imgURL;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}

