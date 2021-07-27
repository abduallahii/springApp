package com.springAPP.controller;


import com.springAPP.DAO.CustomerDAO;
import com.springAPP.entity.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class customerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomer(Model model){
        List<customer> theCustomers = customerDAO.getCustomers();
        model.addAttribute("customers" , theCustomers);

        return "list-cust";
    }

    @RequestMapping("/ShowFormADD")
    public String ShowFormADD(Model model){
        customer theCustomer = new customer();
        model.addAttribute("customer" , theCustomer);
        return "Customer-Form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer")customer  theCustomer){

        return "redirect:/customer/list";
    }

}
