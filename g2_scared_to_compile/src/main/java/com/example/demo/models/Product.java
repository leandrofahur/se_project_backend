package com.example.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private Float price;
	
	// https://www.tradegecko.com/free-tools/sku-generator
	@Column(name="SKU")
	private String sku;
	
	@Column(name="productPic")
	private String productPic;
	
	@Column(name="isFavorite")
	private Boolean isFavorite;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	//@JsonIgnore 
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinTable(name = "products_categories", 
		joinColumns = {
			@JoinColumn(name = "products_id", referencedColumnName = "id") 
		}, 
		inverseJoinColumns = {
			@JoinColumn(name = "categories_id", referencedColumnName = "id") 
		}
	)
	
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	private Set<Inventory> inventories = new HashSet<>();
	
//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
//	private Set<Discount> discounts = new HashSet<>();
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	// TODO: Remember to re-generate with the new attributes on-hold: 
	public Product(String name, String description, Float price, String sKU, String productPic) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		sku = sKU;
		this.productPic = productPic;
		this.isFavorite = false;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getSKU() {
		return sku;
	}

	public void setSKU(String sKU) {
		sku = sKU;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Boolean getIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	public Set<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}
	
	public void addInventory(Inventory inventory) {
		this.inventories.add(inventory);
		inventory.setProduct(this);
	}

	public String getProductPic() {
		return productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}
	
//	public Set<Discount> getDiscounts() {
//		return discounts;
//	}

//	public void setDiscounts(Set<Discount> discounts) {
//		this.discounts = discounts;
//	}
	
//	public void addDiscount(Discount discount) {
//		this.discounts.add(discount);
//		discount.setProduct(this);
//	}	
}
