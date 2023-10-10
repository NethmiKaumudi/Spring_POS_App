package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {


    @Autowired
    ItemService itemService;

    @PostMapping
    public ResponseUtil addItem(ItemDTO dto) {
        itemService.addItem(dto);
        return new ResponseUtil("OK", "SuccessFully Added", dto);
    }

    @DeleteMapping(params = {"code"})
    public ResponseUtil deleteItem(String code) {
        itemService.deleteItem(code);
        return new ResponseUtil("OK", "SuccessFully Deleted", code);

    }

    @GetMapping
    public ResponseUtil getAllCustomer() {
        return new ResponseUtil("OK", "SuccessFully Loaded", itemService.getAllItem());

    }

    @GetMapping(params = {"code"})
    public ResponseUtil findCustomer(String code) {
        return new ResponseUtil("OK", "SuccessFully Searched", itemService.findItem(code));

    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody ItemDTO i) {
        itemService.updateItem(i);
        return new ResponseUtil("OK", "SuccessFully Updated", i);

    }
}
