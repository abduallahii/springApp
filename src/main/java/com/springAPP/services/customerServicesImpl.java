package com.springAPP.services;

import com.springAPP.DAO.CustomerDAO;
import com.springAPP.entity.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class customerServicesImpl implements customerServices{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<customer> getCustomers(){
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public customer getCustomers(int theId) {

        return customerDAO.getCustomers(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDAO.deleteCustomer(theId);
    }


}
