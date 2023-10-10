package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    public void addItem(ItemDTO dto);

    public void deleteItem(String code);

    public List<ItemDTO> getAllItem();

    public ItemDTO findItem(String code);

    public void updateItem(ItemDTO c);
}
