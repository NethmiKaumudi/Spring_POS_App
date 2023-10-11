package lk.ijse.spring.service;


import lk.ijse.spring.dto.OrdersDTO;

public interface PlaceOrderService {
    void placeOrder(OrdersDTO dto);

    OrdersDTO SearchOrder(String oid);

}
