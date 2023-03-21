package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class OrderDetails 
{
	@Id
	private int id;
	private int customer_id;
	private String paymentMode;
	private int shop_id;
	private String datetime;
	private float total;
	public OrderDetails() {
		
	}
	public OrderDetails(int id, int customer_id, String paymentMode, int shop_id, String datetime, float total) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.paymentMode = paymentMode;
		this.shop_id = shop_id;
		this.datetime = datetime;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
