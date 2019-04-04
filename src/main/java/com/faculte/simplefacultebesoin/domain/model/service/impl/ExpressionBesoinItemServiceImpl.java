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
import com.faculte.simplefacultebesoin.domain.model.service.ExpressionBesoinService;
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

    @Autowired
    ExpressionBesoinService expressionBesoinService;

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

    @Override
    public int deleteItem(Long id) {
        boolean exist = expressionBesoinItemDao.existsById(id);

        if (!exist) {
            return -1;
        } else {
            ExpressionBesoinItem expressionBesoinItem = expressionBesoinItemDao.getOne(id);
            if (expressionBesoinItem.getQuantiteCommander() != 0) {
                return -2;
            } else {
                expressionBesoinItemDao.deleteById(id);
                return 1;
            }
        }
    }

    @Override
    public int accoder(ExpressionBesoinItem expressionBesoinItem) {
        ExpressionBesoinItem ebi = expressionBesoinItemDao.getOne(expressionBesoinItem.getId());

        if (ebi.getQuantiteAccorder() != 0) {
            return -1;
        } else if (expressionBesoinItem.getQuantiteAccorder() > expressionBesoinItem.getQuantiteDemande()) {
            return -2;
        } else {
            expressionBesoinItem.setQuantiteAccorder(expressionBesoinItem.getQuantiteAccorder());
            expressionBesoinItem.setExpressionBesoin(expressionBesoinService.findByReference(ebi.getExpressionBesoin().getReference()));
            expressionBesoinItemDao.save(expressionBesoinItem);
            return 1;
        }
    }

    @Override
    public List<ExpressionBesoinItem> findByReferenceProduit(String referenceProduit) {
        return expressionBesoinItemDao.findByReferenceProduit(referenceProduit);
    }

    public ExpressionBesoinItemDao getExpressionBesoinItemDao() {
        return expressionBesoinItemDao;
    }

    public void setExpressionBesoinItemDao(ExpressionBesoinItemDao expressionBesoinItemDao) {
        this.expressionBesoinItemDao = expressionBesoinItemDao;
    }

    @Override
    public ExpressionBesoinItem findById(Long id) {
        boolean exist = expressionBesoinItemDao.existsById(id);
        if (exist) {
            ExpressionBesoinItem expressionBesoinItem = expressionBesoinItemDao.getOne(id);
            return expressionBesoinItem;
        } else {
            return null;
        }
    }

    @Override
    public List<ExpressionBesoinItem> findByExpressionBesoinCodeEntity(String codeEntity) {
        return expressionBesoinItemDao.findByExpressionBesoinCodeEntity(codeEntity);
    }

}
