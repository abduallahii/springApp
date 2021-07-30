package com.springAPP.controller;



import com.springAPP.entity.customer;
import com.springAPP.services.customerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class customerController {

    @Autowired
    private customerServices customerservices ;

    @GetMapping("/list")
    public String listCustomer(Model model){
        List<customer> theCustomers = customerservices.getCustomers();
        model.addAttribute("customers" , theCustomers);

        return "list-cust";
    }

    @GetMapping("/ShowFormADD")
    public String ShowFormADD(Model model){
        customer theCustomer = new customer();
        model.addAttribute("customer" , theCustomer);
        return "Customer-Form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer")customer  theCustomer){
        customerservices.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

}
