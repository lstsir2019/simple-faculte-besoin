/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.model.service;

import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoin;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoinItem;
import java.util.List;

/**
 *
 * @author ismail boulaanait
 */
public interface ExpressionBesoinItemService {
    public int create(ExpressionBesoin expressionBesoin,List<ExpressionBesoinItem> expressionBesoinItems);
    public List<ExpressionBesoinItem> findByExpressionBesoinReference(String reference);
    public int deleteItem(Long id);
}
