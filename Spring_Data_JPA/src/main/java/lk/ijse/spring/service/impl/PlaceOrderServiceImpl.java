package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderDetailsRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderDetailsRepo orderDetailsRepo;
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void placeOrder(OrdersDTO dto) {
        if (!orderRepo.existsById(dto.getOid())) {
            Orders orders = mapper.map(dto, Orders.class);
            orderRepo.save(orders);

            List<OrderDetailsDTO> orderDetails = dto.getOrderDetails();
            for (int i = 0; i < orderDetails.size(); i++) {
                OrderDetails details = mapper.map(orderDetails.get(i), OrderDetails.class);
                orderDetailsRepo.save(details);

                Item item = itemRepo.findById(orderDetails.get(i).getItemCode()).get();
                item.setQtyOnHand(item.getQtyOnHand() - orderDetails.get(i).getQty());
            }
        }
    }

    @Override
    public OrdersDTO SearchOrder(String oid) {
        Orders orders = orderRepo.findById(oid).get();
       return mapper.map(orders,OrdersDTO.class);
    }

}
