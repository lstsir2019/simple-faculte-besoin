/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.model.service;

import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoin;
import java.util.List;

/**
 *
 * @author ismail boulaanait
 */
public interface ExpressionBesoinService {
    public ExpressionBesoin findByReference(String reference);
    public int create(ExpressionBesoin expressionBesoin);
    public List<ExpressionBesoin> findAll();
}
