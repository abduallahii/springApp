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
    @Transactional
    public List<customer> getCustomers() {

        Session CurrentSession = sessionFactory.getCurrentSession() ;
        Query<customer> theQuery = CurrentSession.createQuery("from customer" , customer.class);
        List<customer> customers = theQuery.getResultList();
        return customers;

    }
}
