package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.RStatus;
import com.cdac.entity.Order;
import com.cdac.entity.Order;
import com.cdac.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

		@Autowired
		private OrderService orderServ;
		
		@PostMapping("/placeOrder")
		public RStatus placeOrder(@RequestBody Order order) {
			orderServ.placeOrder(order);
			
			RStatus status = new RStatus();
			status.setStatusMessage("order Placed!!");
			status.setStatus(true);
			return status;
		}
}
