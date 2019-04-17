/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.model.search;

import com.faculte.simplefacultebesoin.commun.util.SearchUtil;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoin;
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
public class ExpressionBesoinSearch {
    
    @Autowired
    private EntityManager entityManager;
    
    public List<ExpressionBesoin> findByCriteria(String reference, String codeEntity , Date dateMin , Date dateMax) {
        String query = "SELECT eb FROM ExpressionBesoin eb where 1=1 ";
         //if (reference != null && !reference.equals("")) {
            query+=SearchUtil.addConstraint("eb", "reference", "=", reference);
            //return entityManager.createQuery(query).getResultList();
        //}
         //if (codeEntity != null && !codeEntity.equals("")) {
           query+=SearchUtil.addConstraint("eb", "codeEntity", "=", codeEntity);
       // }
        // System.out.println("haaaaaaa query"+query);
           query+=SearchUtil.addConstraintMinMaxDate("eb", "dateExpression", dateMin, dateMax);
           System.out.println("haaaaaaa query"+query);
         return entityManager.createQuery(query).getResultList();
    }
    
}
