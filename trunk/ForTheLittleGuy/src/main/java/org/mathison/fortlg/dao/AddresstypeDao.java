/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mathison.fortlg.dao;

import java.util.List;
import org.mathison.fortlg.data.Addresstype;

/**
 *
 * @author daryl
 */
public interface AddresstypeDao {
    public List<Addresstype> findAll();
    
    public Addresstype findByName(String name);
}
