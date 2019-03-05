/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ismail boulaanait
 */
@Entity
public class ExpressionBesoinItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String referenceCategorieProduit;
    private String referenceProduit;
    private int quantiteDemande;
    private int quantiteAccorder;
    private int quantiteCommander;
    private String description;
    private int quantiteLivre;
    @ManyToOne
    ExpressionBesoin expressionBesoin;

    public String getReferenceCategorieProduit() {
        return referenceCategorieProduit;
    }

    public void setReferenceCategorieProduit(String referenceCategorieProduit) {
        this.referenceCategorieProduit = referenceCategorieProduit;
    }

    public String getReferenceProduit() {
        return referenceProduit;
    }

    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }

    public int getQuantiteDemande() {
        return quantiteDemande;
    }

    public void setQuantiteDemande(int quantiteDemande) {
        this.quantiteDemande = quantiteDemande;
    }

    public int getQuantiteAccorder() {
        return quantiteAccorder;
    }

    public void setQuantiteAccorder(int quantiteAccorder) {
        this.quantiteAccorder = quantiteAccorder;
    }

    public int getQuantiteCommander() {
        return quantiteCommander;
    }

    public void setQuantiteCommander(int quantiteCommander) {
        this.quantiteCommander = quantiteCommander;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantiteLivre() {
        return quantiteLivre;
    }

    public void setQuantiteLivre(int quantiteLivre) {
        this.quantiteLivre = quantiteLivre;
    }

    public ExpressionBesoin getExpressionBesoin() {
        return expressionBesoin;
    }

    public void setExpressionBesoin(ExpressionBesoin expressionBesoin) {
        this.expressionBesoin = expressionBesoin;
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
        if (!(object instanceof ExpressionBesoinItem)) {
            return false;
        }
        ExpressionBesoinItem other = (ExpressionBesoinItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.faculte.facultebesoin.bean.ExpressionBesoinItem[ id=" + id + " ]";
    }
    
}
