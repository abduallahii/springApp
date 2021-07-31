package com.springAPP.DAO;

import com.springAPP.entity.customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<customer> getCustomers() {

        Session CurrentSession = sessionFactory.getCurrentSession() ;
        Query<customer> theQuery = CurrentSession.createQuery("from customer" , customer.class);
        List<customer> customers = theQuery.getResultList();
        return customers;

    }

    @Override
    public void saveCustomer(customer theCustomer) {
            Session currSession = sessionFactory.getCurrentSession();
            currSession.saveOrUpdate(theCustomer);
    }

    @Override
    public customer getCustomers(int theId) {
        Session currSession = sessionFactory.getCurrentSession();
        return currSession.get(customer.class , theId);
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currSession = sessionFactory.getCurrentSession();
        customer ToDelete = currSession.get(customer.class , theId);
        currSession.delete(ToDelete);
    }


}
