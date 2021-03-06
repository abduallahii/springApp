package com.springAPP.controller;



import com.springAPP.entity.customer;
import com.springAPP.services.customerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/search")
    public String listSearchedCustomer(@ModelAttribute("theSearchName")String  data , Model model){
        List<customer> theCustomers = customerservices.searchCustomers(data);
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

    @GetMapping("/ShowFormUpdate")
    public String showFormForUpdate(@RequestParam("customerID") int theId , Model theModel){
            customer theCustomer = customerservices.getCustomers(theId);
            theModel.addAttribute("customer" , theCustomer);

        return  "Customer-Form" ;
    }

    @GetMapping("/Delete")
    public String Delete(@RequestParam("customerID") int theId ){
        customerservices.deleteCustomer(theId);
        return "redirect:/customer/list";
    }

}
