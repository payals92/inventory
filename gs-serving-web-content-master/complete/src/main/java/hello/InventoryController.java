package hello;

import models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InventoryController {

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        List<Item> list = new ArrayList<Item>();
        list.add(new Item("IPhone",10,1000));
        list.add(new Item("Samsung",13,800));
        list.add(new Item("OnePlus",6,700));

        model.addAttribute("items",list);
        return "inventory";
    }
}
