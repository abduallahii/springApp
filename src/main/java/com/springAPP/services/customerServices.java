package com.springAPP.services;

import com.springAPP.entity.customer;

import java.util.List;

public interface customerServices {
    public List<customer> getCustomers();
    public  void saveCustomer(customer theCustomer) ;
    customer getCustomers(int theId);
    void deleteCustomer(int theId);
    public List<customer> searchCustomers(String data);
}
