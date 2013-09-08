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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daryl
 */
@Repository("addresstypeDao")
@Transactional
public class AddresstypeDaoImpl implements AddresstypeDao {

    @PersistenceContext
    EntityManager em;
    
    @Override
    @Transactional(readOnly=true)
    public List<Addresstype> findAll() {
        TypedQuery<Addresstype> query = em.createNamedQuery("Addresstype.findAll", 
                Addresstype.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly=true)
    public Addresstype findByName(String name) {
        TypedQuery<Addresstype> query = em.createNamedQuery("Addresstype.findByName",
                Addresstype.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
    
}
