/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mathison.fortlg.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.mathison.fortlg.data.Addresstype;
import org.mathison.fortlg.data.Contact;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daryl
 */
@Transactional
public class ContactDaoJpqlImpl implements ContactDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findAll() {
        TypedQuery<Contact> query = em.createNamedQuery("Contact.findAll", Contact.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findByState(String state) {
        TypedQuery<Contact> query = em.createNamedQuery("Contact.findByState",Contact.class);
        return query.setParameter("state", state).getResultList();
    }

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findByCityAndStateAndAddresstype(String city, String state, Addresstype type) {
        TypedQuery<Contact> query = 
                em.createNamedQuery("Contact.findByCityStateAndAddresstype", Contact.class);
        return query.setParameter("city", city)
                .setParameter("state", state)
                .setParameter("addresstypeid", type)
                .getResultList();
    }
    
    
}
