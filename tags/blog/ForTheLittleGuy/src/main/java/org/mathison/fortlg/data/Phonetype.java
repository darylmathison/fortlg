/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mathison.fortlg.data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daryl
 */
@Entity
@Table(name = "PHONETYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phonetype.findAll", query = "SELECT p FROM Phonetype p")})
public class Phonetype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "VERSION")
    @Version
    private Integer version;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "phonetypeid")
    private Collection<Phonenumber> phonenumberCollection;

    public Phonetype() {
    }

    public Phonetype(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Phonenumber> getPhonenumberCollection() {
        return phonenumberCollection;
    }

    public void setPhonenumberCollection(Collection<Phonenumber> phonenumberCollection) {
        this.phonenumberCollection = phonenumberCollection;
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
        if (!(object instanceof Phonetype)) {
            return false;
        }
        Phonetype other = (Phonetype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mathison.fortlg.data.Phonetype[ id=" + id + " ]";
    }
    
}
