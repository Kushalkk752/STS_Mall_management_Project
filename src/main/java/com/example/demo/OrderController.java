package com.example.demo;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController 
{
	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders")
	public List<OrderDetails> list()
	{
		return orderService.listAll();
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<OrderDetails> get(@PathVariable Integer id)
	{
		try
		{
			OrderDetails order = orderService.get(id);
			return new ResponseEntity<OrderDetails>(order, HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
		}	
	}
	//restful API method for create operation
	@PostMapping("/orders")
	public void addOrder(@RequestBody OrderDetails order)
	{
		orderService.save(order);
	}
	
	//restful API method for update operation
	@PutMapping("/orders/{id}")
	public ResponseEntity<?> updateOrder(@RequestBody OrderDetails order, @PathVariable Integer id)
	{
		try
		{
			OrderDetails existOrder = orderService.get(id);
			orderService.save(order);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//restful api method for Delete Operation
	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable Integer id)
	{
		orderService.delete(id);
	}
	
	
}
