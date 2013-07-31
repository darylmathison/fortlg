/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mathison.fortlg.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return em.createQuery("select c from Contact c", Contact.class).getResultList();
    }
    
}
