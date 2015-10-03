/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetapp2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author TamTam
 */
@Entity
@Table(name = "INCOME")
@NamedQueries({
    @NamedQuery(name = "Income.findAll", query = "SELECT i FROM Income i"),
    @NamedQuery(name = "Income.findById", query = "SELECT i FROM Income i WHERE i.id = :id"),
    @NamedQuery(name = "Income.findByIncCategory", query = "SELECT i FROM Income i WHERE i.incCategory = :incCategory"),
    @NamedQuery(name = "Income.findByIncDate", query = "SELECT i FROM Income i WHERE i.incDate = :incDate"),
    @NamedQuery(name = "Income.findByIncAmount", query = "SELECT i FROM Income i WHERE i.incAmount = :incAmount")})
public class Income implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "INC_CATEGORY")
    private String incCategory;
    @Column(name = "INC_DATE")
    @Temporal(TemporalType.DATE)
    private Date incDate;
    @Column(name = "INC_AMOUNT")
    private Integer incAmount;

    public Income() {
    }

    public Income(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getIncCategory() {
        return incCategory;
    }

    public void setIncCategory(String incCategory) {
        String oldIncCategory = this.incCategory;
        this.incCategory = incCategory;
        changeSupport.firePropertyChange("incCategory", oldIncCategory, incCategory);
    }

    public Date getIncDate() {
        return incDate;
    }

    public void setIncDate(Date incDate) {
        Date oldIncDate = this.incDate;
        this.incDate = incDate;
        changeSupport.firePropertyChange("incDate", oldIncDate, incDate);
    }

    public Integer getIncAmount() {
        return incAmount;
    }

    public void setIncAmount(Integer incAmount) {
        Integer oldIncAmount = this.incAmount;
        this.incAmount = incAmount;
        changeSupport.firePropertyChange("incAmount", oldIncAmount, incAmount);
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
        if (!(object instanceof Income)) {
            return false;
        }
        Income other = (Income) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "budgetapp2.Income[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
