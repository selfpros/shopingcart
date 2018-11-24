package com.Ibm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	
	@NotBlank(message = "please enter the Product Name!")
	private String name;
	@Column(name = "code")
	private String code;
	
	@Column(name = "brand")
	@NotBlank(message = "please enter the brand name")
	private String brand;
	@Column(name = "unitprice")
	@Min(value = 1, message = "The price cannot be less Than 1")
	private double unitPrice;

	private int quantity;
	
	@Column(name = "is_active")
	private boolean active;
	
	@Column(name = " description")
	@NotBlank(message = "Please Enter the Description..! for Product")
	private String description;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "supplierid")
	private int suplierid;
	private int purchases;
	private int views;
	
	@Transient
	private MultipartFile file;
	public Products(int id, String name, String code, String brand, double unitPrice, int quantity, boolean active,
			String description, int categoryId, int suplierid, int purchases, int views, MultipartFile file) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.brand = brand;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.active = active;
		this.description = description;
		this.categoryId = categoryId;
		this.suplierid = suplierid;
		this.purchases = purchases;
		this.views = views;
		this.file = file;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	

	public Products() {
		super();
	}

	public Products(int id) {
		super();
		this.id = id;
	}

	public Products(int id, String name, String code, String brand, double unitPrice, int quantity, boolean active,
			String description, int categoryId, int suplierid, int purchases, int views) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.brand = brand;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.active = active;
		this.description = description;
		this.categoryId = categoryId;
		this.suplierid = suplierid;
		this.purchases = purchases;
		this.views = views;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSuplierid() {
		return suplierid;
	}

	public void setSuplierid(int suplierid) {
		this.suplierid = suplierid;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", code=" + code + ", brand=" + brand + ", unitPrice="
				+ unitPrice + ", quantity=" + quantity + ", active=" + active + ", description=" + description
				+ ", categoryId=" + categoryId + ", suplierid=" + suplierid + ", purchases=" + purchases + ", views="
				+ views + "]";
	}

}
