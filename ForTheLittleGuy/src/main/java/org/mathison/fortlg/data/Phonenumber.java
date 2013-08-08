/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mathison.fortlg.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daryl
 */
@Entity
@Table(name = "PHONENUMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phonenumber.findAll", query = "SELECT p FROM Phonenumber p")})
public class Phonenumber implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "VERSION")
    @Version
    private Integer version;
    @Basic(optional = false)
    @Column(name = "NUMBER")
    private String number;
    @JoinColumn(name = "PHONETYPEID", referencedColumnName = "ID")
    @ManyToOne
    private Phonetype phonetypeid;
    @JoinColumn(name = "CONTACTID", referencedColumnName = "ID")
    @ManyToOne
    private Contact contactid;

    public Phonenumber() {
    }

    public Phonenumber(Integer id) {
        this.id = id;
    }

    public Phonenumber(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Phonetype getPhonetypeid() {
        return phonetypeid;
    }

    public void setPhonetypeid(Phonetype phonetypeid) {
        this.phonetypeid = phonetypeid;
    }

    public Contact getContactid() {
        return contactid;
    }

    public void setContactid(Contact contactid) {
        this.contactid = contactid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phonenumber)) {
            return false;
        }
        Phonenumber other = (Phonenumber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mathison.fortlg.data.Phonenumber[ id=" + id + " ]";
    }
    
}
