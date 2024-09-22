package com.cdac.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Order;
import com.cdac.entity.Order.Status;
import com.cdac.entity.OrderItem;
import com.cdac.entity.Product;
import com.cdac.repository.OrderRepo;
import com.cdac.repository.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {

		@Autowired
		private OrderRepo orderRepo;
		
		@Autowired
		private ProductRepo productRepo;
		
		public void placeOrder(Order order) {
			double totalAmount = 0;
			for(OrderItem item: order.getOrderItem()) {
				item.setOrder(order);
				Product product = productRepo.findById(item.getProduct().getId()).get();
				double subTotal=product.getPrice()*item.getQuantity();
				item.setSubTotal(subTotal);
			   totalAmount += subTotal;
			}
			order.setTotalAmount(totalAmount);
			order.setDate(LocalDate.now());
			order.setStatus(Status.CONFIRMED);
			orderRepo.save(order);
			
			
		}
		
}
