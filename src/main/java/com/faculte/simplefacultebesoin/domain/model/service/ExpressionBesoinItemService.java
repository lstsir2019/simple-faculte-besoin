/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.model.service;

import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoin;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoinItem;
import com.faculte.simplefacultebesoin.domain.rest.vo.ExpressionBesoinItemVo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ismail boulaanait
 */
public interface ExpressionBesoinItemService {
    public int create(ExpressionBesoin expressionBesoin,List<ExpressionBesoinItem> expressionBesoinItems);
    public List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference);
    public int deleteItem(Long id);
    public int accoder(ExpressionBesoinItem expressionBesoinItem);
    public ExpressionBesoinItem findById(Long id);
    public List<ExpressionBesoinItemVo> findByReferenceProduit(String referenceProduit);
    public List<ExpressionBesoinItem> findByExpressionBesoinCodeEntity(String codeEntity);
    public int incrementQteLivre(Long id,int qte);
    public int decrementQteLivre(Long id,int qte);
    public int incrementQteCommande(Long id,int qte);
    public int decrementQteCommande(Long id,int qte);
    public List<ExpressionBesoinItemVo> searchByDate(Date dateMin , Date dateMax,String referenceProduit);  
    
}
