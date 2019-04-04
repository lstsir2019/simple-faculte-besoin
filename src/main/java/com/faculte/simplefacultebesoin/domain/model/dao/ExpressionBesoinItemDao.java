/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.model.dao;

import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoinItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ismail boulaanait
 */
@Repository
public interface ExpressionBesoinItemDao extends JpaRepository<ExpressionBesoinItem, Long>{
    public List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference);
    public List<ExpressionBesoinItem> findByReferenceProduit(String referenceProduit);
    public List<ExpressionBesoinItem> findByExpressionBesoinCodeEntity(String codeEntity);
    
}
