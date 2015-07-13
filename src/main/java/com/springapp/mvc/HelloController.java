package com.springapp.mvc;

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

        model.addAttribute("message", redeemCouponService.redeemCoupon(668));
        return "hello";
    }
}