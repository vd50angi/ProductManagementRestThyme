package com.cogent.productmanagementrestthyme.model;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;


@Entity
@Table(name= "product")
public class Product {

@Id

private int productCode;
private String productName;
private int quantity;
private double totalPrice;
public int getProductCode() {
	return productCode;
}
public void setProductCode(int productCode) {
	this.productCode = productCode;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}

	// TODO Auto-generated method stub
	




}
	