package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService 
{
	@Autowired
	OrderRepository repo;
	public List<OrderDetails> listAll() 
	{
		return repo.findAll();
	}

	public OrderDetails get(Integer id) 
	{
		return repo.findById(id).get();
	}

	public void save(OrderDetails order) 
	{	
		repo.save(order);
	}

	public void delete(Integer id) 
	{
		repo.deleteById(id);
	}
}
