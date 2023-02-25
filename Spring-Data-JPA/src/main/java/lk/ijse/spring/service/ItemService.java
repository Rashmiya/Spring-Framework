package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;
import java.util.ArrayList;

public interface ItemService {

    public void addItem(ItemDTO dto);

    public void updateItem(ItemDTO dto);

    public void deleteItem(String code);

    public ArrayList<ItemDTO> getAllItems();
}
