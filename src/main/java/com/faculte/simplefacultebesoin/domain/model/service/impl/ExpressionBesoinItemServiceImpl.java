/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.model.service.impl;

import com.faculte.simplefacultebesoin.commun.util.NumberUtil;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoin;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoinItem;
import com.faculte.simplefacultebesoin.domain.model.dao.ExpressionBesoinItemDao;
import com.faculte.simplefacultebesoin.domain.model.search.ExpressionBesoinItemSearch;
import com.faculte.simplefacultebesoin.domain.model.service.ExpressionBesoinItemService;
import com.faculte.simplefacultebesoin.domain.model.service.ExpressionBesoinService;
import com.faculte.simplefacultebesoin.domain.rest.vo.ExpressionBesoinItemVo;
import java.util.ArrayList;
import java.util.Date;
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
    
    
    @Autowired
    ExpressionBesoinItemSearch expressionBesoinItemSearch;

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
    public List<ExpressionBesoinItemVo> findByReferenceProduit(String referenceProduit) {
        List<ExpressionBesoinItem> data = expressionBesoinItemDao.findByReferenceProduit(referenceProduit);
        List<ExpressionBesoinItemVo> res = new ArrayList();
        for (ExpressionBesoinItem expressionBesoinItem : data) {
            if (expressionBesoinItem.getQuantiteCommander() != expressionBesoinItem.getQuantiteAccorder()) {
                ExpressionBesoinItemVo ebiv = new ExpressionBesoinItemVo();
                ebiv.setId(expressionBesoinItem.getId());
                ebiv.setReferenceProduit(expressionBesoinItem.getReferenceProduit());
                ebiv.setQuantiteAccorder(NumberUtil.inttoString(expressionBesoinItem.getQuantiteAccorder()));
                ebiv.setQuantiteCommander(NumberUtil.inttoString(expressionBesoinItem.getQuantiteCommander()));
                ebiv.setEntityAdmin(expressionBesoinItem.getExpressionBesoin().getCodeEntity());
                res.add(ebiv);
            }

        }
        return res;
    }

    @Override
    public int incrementQteLivre(Long id, int qte) {
        ExpressionBesoinItem ebi = this.findById(id);
        if (ebi == null) {
            return -1;
        } else {
            if (qte > ebi.getQuantiteCommander() - ebi.getQuantiteLivre()) {
                return -2;
            } else {
                ebi.setQuantiteLivre(ebi.getQuantiteLivre() + qte);
                expressionBesoinItemDao.save(ebi);
                return 1;
            }
        }
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

    @Override
    public int incrementQteCommande(Long id, int qte) {
        ExpressionBesoinItem expressionBesoinItem = this.findById(id);
        if (expressionBesoinItem == null) {
            return -1;
        } else if (qte > expressionBesoinItem.getQuantiteAccorder() - expressionBesoinItem.getQuantiteCommander()) {
            return -2;
        } else {
            expressionBesoinItem.setQuantiteCommander(expressionBesoinItem.getQuantiteCommander() + qte);
            expressionBesoinItemDao.save(expressionBesoinItem);
            return 1;
        }
    }

    @Override
    public int decrementQteCommande(Long id, int qte) {
        ExpressionBesoinItem expressionBesoinItem = this.findById(id);
        if (expressionBesoinItem == null) {
            return -1;
        }else if (qte > expressionBesoinItem.getQuantiteCommander()) {
            return -2;
        }else{
            expressionBesoinItem.setQuantiteCommander(expressionBesoinItem.getQuantiteCommander() - qte);
            expressionBesoinItemDao.save(expressionBesoinItem);
            return 1;
        }
    }

    
    @Override
    public List<ExpressionBesoinItemVo> searchByDate(Date dateMin , Date dateMax,String referenceProduit) {
        List<ExpressionBesoinItem> data = expressionBesoinItemSearch.searchByDate(dateMin, dateMax,referenceProduit);
           List<ExpressionBesoinItemVo> res = new ArrayList();
        for (ExpressionBesoinItem expressionBesoinItem : data) {
            if (expressionBesoinItem.getQuantiteCommander() != expressionBesoinItem.getQuantiteAccorder()) {
                ExpressionBesoinItemVo ebiv = new ExpressionBesoinItemVo();
                ebiv.setId(expressionBesoinItem.getId());
                ebiv.setReferenceProduit(expressionBesoinItem.getReferenceProduit());
                ebiv.setQuantiteAccorder(NumberUtil.inttoString(expressionBesoinItem.getQuantiteAccorder()));
                ebiv.setQuantiteCommander(NumberUtil.inttoString(expressionBesoinItem.getQuantiteCommander()));
                ebiv.setEntityAdmin(expressionBesoinItem.getExpressionBesoin().getCodeEntity());
                res.add(ebiv);
            }

        }
        return res;
    }
}
