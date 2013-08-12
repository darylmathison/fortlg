package org.mathison.fortlg;

import java.util.List;
import org.mathison.fortlg.dao.AddresstypeDao;
import org.mathison.fortlg.dao.ContactDao;
import org.mathison.fortlg.data.Addresstype;
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
        System.out.println();
        List<Contact> findbystate = contactDao.findByState("Texas");
        for(Contact c: findbystate){
            System.out.println(c);
        }
        System.out.println();
        AddresstypeDao addresstypeDao = context.getBean("addresstypeDao", AddresstypeDao.class);
        Addresstype type = addresstypeDao.findByName("Work");
        List<Contact> findbycitystatetype = contactDao.findByCityAndStateAndAddresstype("San Antonio", "Texas", type);
        for(Contact c: findbycitystatetype) {
            System.out.println(c);
        }
    }
}
