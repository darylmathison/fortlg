/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mathison.fortlg.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
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
@Table(name = "ADDRESSTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addresstype.findAll", query = "SELECT a FROM Addresstype a"),
    @NamedQuery(name = "Addresstype.findByName", query = "select a from Addresstype a where name = :name")})
public class Addresstype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "VERSION")
    @Version
    private Integer version;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "addresstypeid")
    private Set<Address> addressCollection;

    public Addresstype() {
    }

    public Addresstype(Integer id) {
        this.id = id;
    }

    public Addresstype(Integer id, String name) {
        this.id = id;
        this.name = name;
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
    public Set<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Set<Address> addressCollection) {
        this.addressCollection = addressCollection;
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
        if (!(object instanceof Addresstype)) {
            return false;
        }
        Addresstype other = (Addresstype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mathison.fortlg.data.Addresstype[ id=" + id + " ]";
    }
    
}
