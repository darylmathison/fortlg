/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mathison.fortlg.dao;

import java.util.List;
import org.mathison.fortlg.data.Contact;

/**
 *
 * @author Daryl Mathison
 */
public interface ContactDao {
    public List<Contact> findAll();
}
