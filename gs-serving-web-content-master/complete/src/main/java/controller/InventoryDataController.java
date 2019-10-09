package controller;

import models.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryDataController {

    @GetMapping("/moreData")
    public List<Item> getData(){
            List<Item> list = new ArrayList<Item>();
            list.add(new Item("IPhone",10,1000));
            list.add(new Item("Samsung",13,800));
            list.add(new Item("OnePlus",6,700));

            return list;
    }
}
