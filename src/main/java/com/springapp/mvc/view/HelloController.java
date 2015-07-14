package com.springapp.mvc.view;

import com.springapp.mvc.exception.MyDatabaseException;
import com.springapp.mvc.service.RedeemCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    @Autowired
    private RedeemCouponService redeemCouponService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        try {
            model.addAttribute("message", redeemCouponService.redeemCoupon(668));
        } catch (MyDatabaseException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "hello";
    }
}