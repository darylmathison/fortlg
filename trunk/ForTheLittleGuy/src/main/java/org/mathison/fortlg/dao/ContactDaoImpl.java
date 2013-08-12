/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mathison.fortlg.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.mathison.fortlg.data.Address;
import org.mathison.fortlg.data.Addresstype;
import org.mathison.fortlg.data.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Daryl Mathison
 */
@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public List<Contact> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
        Root<Contact> c = cq.from(Contact.class);
        c.fetch("addressCollection");
        c.fetch("phonenumberCollection");
        cq.select(c);
        cq.distinct(true);
        TypedQuery<Contact> query = em.createQuery(cq);
        return query.getResultList();
        //return em.createQuery("select c from Contact c", Contact.class).getResultList();
    }

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findByState(String state) {
         CriteriaBuilder cb = em.getCriteriaBuilder();
         CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
         Root<Contact> c = cq.from(Contact.class);
         Join<Contact,Address> ca = c.join("addressCollection");
         c.fetch("phonenumberCollection");
         c.fetch("addressCollection");
         cq.select(c);
         cq.distinct(true);
         cq.where(cb.equal(ca.get("state"), state));
         TypedQuery<Contact> query = em.createQuery(cq);
         return query.getResultList();
    }

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findByCityAndStateAndAddresstype(String city, String state, 
        Addresstype addresstype) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
        Root<Contact> c = cq.from(Contact.class);
        Join<Contact,Address> ca = c.join("addressCollection");
        c.fetch("addressCollection");
        c.fetch("phonenumberCollection");
        cq.select(c);
        cq.distinct(true);
        Predicate cityp = cb.equal(ca.get("city"), city);
        Predicate statep = cb.equal(ca.get("state"),state);
        Predicate typep = cb.equal(ca.get("addresstypeid"), addresstype);
        cq.where(cb.and(cityp, statep, typep));
        
        TypedQuery<Contact> query = em.createQuery(cq);
        return query.getResultList();
    }
    
    
    
}
