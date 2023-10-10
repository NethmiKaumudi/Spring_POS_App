package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.service.PlaceOrderService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.ArrayList;

@WebAppConfiguration // create testing context
@ContextConfiguration(classes = {WebRootConfig.class}) //load configurations which wanted for test context
@ExtendWith(SpringExtension.class)
class PlaceOrderServiceImplTest {
//    @Autowired
//    PlaceOrderService placeOrderService;
    @Test
    void placeOrder() {
//        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
//
//        OrdersDTO order = new OrdersDTO("O001", 2023 - 10 - 11, "C001",new ArrayList<>("I001", "O001", 10, new BigDecimal(100.00)));
//        placeOrderService.placeOrder(order);
    }
}