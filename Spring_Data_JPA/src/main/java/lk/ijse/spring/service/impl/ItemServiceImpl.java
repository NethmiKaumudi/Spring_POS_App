package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    ModelMapper mapper;

    public ItemServiceImpl() {
        System.out.println("ItemServiceImpl instantiated");

    }

    @Override
    public void addItem(ItemDTO dto) {
        itemRepo.save(mapper.map(dto, Item.class));
    }

    @Override
    public void deleteItem(String code) {
        itemRepo.deleteById(code);
    }

    @Override
    public List<ItemDTO> getAllItem() {
        List<Item> all = itemRepo.findAll();
        return mapper.map(all, new TypeToken<List<ItemDTO>>() {
        }.getType());
    }

    @Override
    public ItemDTO findItem(String code) {
        Item item = itemRepo.findById(code).get();
        return mapper.map(item, ItemDTO.class);
    }

    @Override
    public void updateItem(ItemDTO c) {
        Item map = mapper.map(c, Item.class);
        itemRepo.save(map);
    }
}
