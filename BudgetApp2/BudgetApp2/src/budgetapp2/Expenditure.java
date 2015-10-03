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
@Table(name = "EXPENDITURE")
@NamedQueries({
    @NamedQuery(name = "Expenditure.findAll", query = "SELECT e FROM Expenditure e"),
    @NamedQuery(name = "Expenditure.findById", query = "SELECT e FROM Expenditure e WHERE e.id = :id"),
    @NamedQuery(name = "Expenditure.findByExpCategory", query = "SELECT e FROM Expenditure e WHERE e.expCategory = :expCategory"),
    @NamedQuery(name = "Expenditure.findByExpDate", query = "SELECT e FROM Expenditure e WHERE e.expDate = :expDate"),
    @NamedQuery(name = "Expenditure.findByExpAmount", query = "SELECT e FROM Expenditure e WHERE e.expAmount = :expAmount")})
public class Expenditure implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "EXP_CATEGORY")
    private String expCategory;
    @Column(name = "EXP_DATE")
    @Temporal(TemporalType.DATE)
    private Date expDate;
    @Column(name = "EXP_AMOUNT")
    private Integer expAmount;

    public Expenditure() {
    }

    public Expenditure(Integer id) {
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

    public String getExpCategory() {
        return expCategory;
    }

    public void setExpCategory(String expCategory) {
        String oldExpCategory = this.expCategory;
        this.expCategory = expCategory;
        changeSupport.firePropertyChange("expCategory", oldExpCategory, expCategory);
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        Date oldExpDate = this.expDate;
        this.expDate = expDate;
        changeSupport.firePropertyChange("expDate", oldExpDate, expDate);
    }

    public Integer getExpAmount() {
        return expAmount;
    }

    public void setExpAmount(Integer expAmount) {
        Integer oldExpAmount = this.expAmount;
        this.expAmount = expAmount;
        changeSupport.firePropertyChange("expAmount", oldExpAmount, expAmount);
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
        if (!(object instanceof Expenditure)) {
            return false;
        }
        Expenditure other = (Expenditure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "budgetapp2.Expenditure[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
