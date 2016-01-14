package opensource.onlinestore.controllers;

import opensource.onlinestore.model.GoodsEntity;
import opensource.onlinestore.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreController {
    @Autowired
    private GoodsRepository goodsRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("text", "Hello! This is example main page");
        return "index";
    }
}
