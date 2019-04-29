/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.model.search;

import com.faculte.simplefacultebesoin.commun.util.SearchUtil;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoinItem;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ismail
 */
@Repository
public class ExpressionBesoinItemSearch {
    
    @Autowired
    private EntityManager entityManager;
    
    public List<ExpressionBesoinItem> searchByDate(Date dateMin , Date dateMax,String referenceProduit) {
        String query = "SELECT eb FROM ExpressionBesoinItem eb where 1=1 ";
        
            query+=" and referenceProduit='"+referenceProduit+"'";
        
           query+=SearchUtil.addConstraintMinMaxDate("eb", "expressionBesoin.dateExpression", dateMin, dateMax);
           System.out.println("haaaaaaa query"+query);
         return entityManager.createQuery(query).getResultList();
    }
    
}
