package com.springAPP.DAO;

import com.springAPP.entity.customer;
import java.util.List;

public interface CustomerDAO {
    public List<customer> getCustomers();

    public void saveCustomer(customer theCustomer);

    customer getCustomers(int theId);

    void deleteCustomer(int theId);
}
