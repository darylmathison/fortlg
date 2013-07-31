package org.mathison.fortlg;

import java.util.List;
import org.mathison.fortlg.dao.ContactDao;
import org.mathison.fortlg.data.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new GenericXmlApplicationContext("app-config.xml");
        
        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
        List<Contact> contacts = contactDao.findAll();
        for(Contact c: contacts) {
            System.out.println(c);
        }
    }
}
