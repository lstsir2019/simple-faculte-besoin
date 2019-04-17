/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.rest.vo;

import java.util.List;

/**
 *
 * @author ismail boulaanait
 */
public class ExpressionBesoinVo {
    private Long id;
    private String reference;
    private String codeEntity;
    private String codePersonel;
    private String dateExpression ;
    private String dateMin ;
    private String dateMax ;
    private List<ExpressionBesoinItemVo> expressionBesoinItemsVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCodeEntity() {
        return codeEntity;
    }

    public void setCodeEntity(String codeEntity) {
        this.codeEntity = codeEntity;
    }

    public String getCodePersonel() {
        return codePersonel;
    }

    public void setCodePersonel(String codePersonel) {
        this.codePersonel = codePersonel;
    }

    public String getDateExpression() {
        return dateExpression;
    }

    public void setDateExpression(String dateExpression) {
        this.dateExpression = dateExpression;
    }

    public List<ExpressionBesoinItemVo> getExpressionBesoinItemsVos() {
        return expressionBesoinItemsVos;
    }

    public void setExpressionBesoinItemsVos(List<ExpressionBesoinItemVo> expressionBesoinItemsVos) {
        this.expressionBesoinItemsVos = expressionBesoinItemsVos;
    }

    public String getDateMin() {
        return dateMin;
    }

    public void setDateMin(String dateMin) {
        this.dateMin = dateMin;
    }

    public String getDateMax() {
        return dateMax;
    }

    public void setDateMax(String dateMax) {
        this.dateMax = dateMax;
    }
    
    
    
}
