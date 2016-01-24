package opensource.onlinestore.controllers;

import opensource.onlinestore.model.dto.GoodsDTO;
import opensource.onlinestore.model.dto.PaymentResponseDTO;
import opensource.onlinestore.service.GoodsService;
import opensource.onlinestore.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StoreController {

    private static final Logger LOG = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "main";
    }

    //todo: Secure with hasRole("ADMIN") when security configured
    @RequestMapping(value = "/admin/addgoods", method = RequestMethod.POST)
    @ResponseBody
    public boolean addGoods(GoodsDTO goods) {
        return goodsService.addGoods(goods);
    }

//    @RequestMapping(value = "/getgoods", method = RequestMethod.GET)
//    @ResponseBody
//    public List<GoodsDTO> getGoods(Category category) {
//        return goodsService.getGoods(category);
//    }

    //todo: Secure with hasRole("USER") when security configured
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    @ResponseBody
    public PaymentResponseDTO payment(List<GoodsDTO> goods) {
        return paymentService.pay(goods);
    }

}
