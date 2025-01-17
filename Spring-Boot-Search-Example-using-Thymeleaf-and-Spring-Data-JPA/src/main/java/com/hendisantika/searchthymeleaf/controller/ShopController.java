package com.hendisantika.searchthymeleaf.controller;

import com.hendisantika.searchthymeleaf.model.Shop;
import com.hendisantika.searchthymeleaf.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @RequestMapping(path = {"/", "/search"})
    public String home(Shop shop, Model model, String keyword) {
        if (keyword != null) {
            List<Shop> list = shopService.getByKeyword(keyword);
            model.addAttribute("list", list);
        } else {
            List<Shop> list = shopService.getAllShops();
            model.addAttribute("list", list);
        }
        return "index";
    }
}
