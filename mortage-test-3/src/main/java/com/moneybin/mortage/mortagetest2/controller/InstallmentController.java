package com.moneybin.mortage.mortagetest2.controller;

import com.moneybin.mortage.mortagetest2.model.Customer;
import com.moneybin.mortage.mortagetest2.service.MonthlyInstallmentCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InstallmentController {

    @Autowired
    private MonthlyInstallmentCalculator monthlyInstallmentCalculator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "index";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public ModelAndView fetchAllCalculatedInstallment(@ModelAttribute("customer") Customer customer) {
        Customer newAttribute = monthlyInstallmentCalculator.calculate(customer);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("customer", newAttribute);
        return mav;
    }
}
