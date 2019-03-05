/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.model.service.impl;


import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoin;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoinItem;
import com.faculte.simplefacultebesoin.domain.model.dao.ExpressionBesoinItemDao;
import com.faculte.simplefacultebesoin.domain.model.service.ExpressionBesoinItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ismail boulaanait
 */
@Service
public class ExpressionBesoinItemServiceImpl implements ExpressionBesoinItemService {

    @Autowired
    ExpressionBesoinItemDao expressionBesoinItemDao;

    @Override
    public int create(ExpressionBesoin expressionBesoin, List<ExpressionBesoinItem> expressionBesoinItems) {
        if (expressionBesoinItems == null || expressionBesoinItems.isEmpty()) {

            return -1;
        } else {
            for (ExpressionBesoinItem expressionBesoinItem : expressionBesoinItems) {
                expressionBesoinItem.setExpressionBesoin(expressionBesoin);
                expressionBesoinItem.setQuantiteAccorder(0);
                expressionBesoinItem.setQuantiteCommander(0);
                expressionBesoinItem.setQuantiteLivre(0);
                expressionBesoinItemDao.save(expressionBesoinItem);
            }

            return 1;
        }
    }
    
    @Override
    public List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference) {
       return expressionBesoinItemDao.findByExpressionBesoinReference(reference);
    }

    public ExpressionBesoinItemDao getExpressionBesoinItemDao() {
        return expressionBesoinItemDao;
    }

    public void setExpressionBesoinItemDao(ExpressionBesoinItemDao expressionBesoinItemDao) {
        this.expressionBesoinItemDao = expressionBesoinItemDao;
    }

    @Override
    public int deleteItem(Long id) {
        expressionBesoinItemDao.deleteById(id);
        return 1;
    }
    

    
}
