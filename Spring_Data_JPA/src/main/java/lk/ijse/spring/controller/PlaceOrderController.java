package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.service.PlaceOrderService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/place_order")
@CrossOrigin
public class PlaceOrderController {
    @Autowired
    PlaceOrderService service;


    @PostMapping
    public ResponseUtil purchaseOrder(@RequestBody OrdersDTO od) {
        return new ResponseUtil("Ok", "Successfully Purchased", od);
    }

    @GetMapping(params = {"oid"})
    public ResponseUtil SearchOrder(String oid) {
        return new ResponseUtil("OK", "SuccessFully Searched", service.SearchOrder(oid));

    }
}
