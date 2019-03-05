/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author ismail boulaanait
 */
@Entity
public class ExpressionBesoin implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private String codeEntity;
    private String codePersonel;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateExpression ;
    @OneToMany(mappedBy = "expressionBesoin")
    private List<ExpressionBesoinItem> expressionBesoinItems;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    public String getCodeEntity() {
        return codeEntity;
    }

    public void setCodeEntity(String codeEntity) {
        this.codeEntity = codeEntity;
    }

    public String getCodePersonel() {
        return codePersonel;
    }

    public void setCodePersonel(String codePersonel) {
        this.codePersonel = codePersonel;
    }

    public Date getDateExpression() {
        return dateExpression;
    }

    public void setDateExpression(Date dateExpression) {
        this.dateExpression = dateExpression;
    }
    @JsonIgnore
    public List<ExpressionBesoinItem> getExpressionBesoinItems() {
        return expressionBesoinItems;
    }
    @JsonSetter
    public void setExpressionBesoinItems(List<ExpressionBesoinItem> expressionBesoinItems) {
        this.expressionBesoinItems = expressionBesoinItems;
    }
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof ExpressionBesoin)) {
            return false;
        }
        ExpressionBesoin other = (ExpressionBesoin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.faculte.facultebesoin.bean.ExpressionBesoin[ id=" + id + " ]";
    }
    
}
