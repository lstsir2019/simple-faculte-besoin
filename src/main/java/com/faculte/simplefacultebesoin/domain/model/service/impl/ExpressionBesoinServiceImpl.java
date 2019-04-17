/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.model.service.impl;

import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoin;
import com.faculte.simplefacultebesoin.domain.model.dao.ExpressionBesoinDao;
import com.faculte.simplefacultebesoin.domain.model.search.ExpressionBesoinSearch;
import com.faculte.simplefacultebesoin.domain.model.service.ExpressionBesoinItemService;
import com.faculte.simplefacultebesoin.domain.model.service.ExpressionBesoinService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ismail boulaanait
 */
@Service
public class ExpressionBesoinServiceImpl implements ExpressionBesoinService {

    @Autowired
    ExpressionBesoinDao expressionBesoinDao;

    @Autowired
    ExpressionBesoinItemService expressionBesoinItemService;
    
    @Autowired
    ExpressionBesoinSearch expressionBesoinSearch;

    @Override
    public List<ExpressionBesoin> findAll() {
        return expressionBesoinDao.findAll();
    }

    @Override
    public int create(ExpressionBesoin expressionBesoin) {
        if (expressionBesoinDao.findByReference(expressionBesoin.getReference()) != null) {
            return -1;
        } else {
            expressionBesoinDao.save(expressionBesoin);

            expressionBesoinItemService.create(expressionBesoin, expressionBesoin.getExpressionBesoinItems());

            return 1;
        }
    }
    

    @Override
    public List<ExpressionBesoin> findByCriteria(String reference, String codeEntity , Date dateMin , Date dateMax) {
            return expressionBesoinSearch.findByCriteria(reference, codeEntity,dateMin,dateMax);
    }

    @Override
    public ExpressionBesoin findByReference(String reference) {
        return expressionBesoinDao.findByReference(reference);
    }

    public ExpressionBesoinDao getExpressionBesoinDao() {
        return expressionBesoinDao;
    }

    public void setExpressionBesoinDao(ExpressionBesoinDao expressionBesoinDao) {
        this.expressionBesoinDao = expressionBesoinDao;
    }

    public ExpressionBesoinItemService getExpressionBesoinItemService() {
        return expressionBesoinItemService;
    }

    public void setExpressionBesoinItemService(ExpressionBesoinItemService expressionBesoinItemService) {
        this.expressionBesoinItemService = expressionBesoinItemService;
    }

    public ExpressionBesoinSearch getExpressionBesoinSearch() {
        return expressionBesoinSearch;
    }

    public void setExpressionBesoinSearch(ExpressionBesoinSearch expressionBesoinSearch) {
        this.expressionBesoinSearch = expressionBesoinSearch;
    }
    
    

}
