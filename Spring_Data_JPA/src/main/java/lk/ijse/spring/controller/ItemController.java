package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {


    @Autowired
    ItemService itemService;

    @PostMapping
    public void addItem(ItemDTO dto) {
        itemService.addItem(dto);
    }

    @DeleteMapping(params = {"code"})
    public void deleteItem(String code) {
        itemService.deleteItem(code);
    }

    @GetMapping
    public List<ItemDTO> getAllCustomer() {
        return itemService.getAllItem();
    }

    @GetMapping(params = {"code"})
    public ItemDTO findCustomer(String code) {
        return itemService.findItem(code);
    }

    @PutMapping
    public void updateCustomer(@RequestBody ItemDTO c) {
        itemService.updateItem(c);
    }
}
