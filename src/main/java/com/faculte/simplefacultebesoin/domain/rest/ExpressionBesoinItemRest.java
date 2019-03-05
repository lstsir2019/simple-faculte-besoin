/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.rest;


import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoinItem;
import com.faculte.simplefacultebesoin.domain.model.service.ExpressionBesoinItemService;
import com.faculte.simplefacultebesoin.domain.rest.converter.AbstractConverter;
import com.faculte.simplefacultebesoin.domain.rest.vo.ExpressionBesoinItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ismail boulaanait
 */
@RestController()
@CrossOrigin(origins={"http://localhost:4200"})
@RequestMapping({"/faculte-besoin/item"})
public class ExpressionBesoinItemRest {

    @Autowired
    ExpressionBesoinItemService expressionBesoinItemService;
    
    @Autowired
    @Qualifier("expressionBesoinItemConverter")
    private AbstractConverter<ExpressionBesoinItem, ExpressionBesoinItemVo> expressionBesoinItemConverter;
    //======================================================================================
    //@PutMapping("/delete/{id}")
    @DeleteMapping("/delete/{id}")
    public int deleteItem(@PathVariable Long id) {
        return expressionBesoinItemService.deleteItem(id);
    }
    
    
    
    // ===========Getter & Setter ===========
    public ExpressionBesoinItemService getExpressionBesoinItemService() {
        return expressionBesoinItemService;
    }

    public void setExpressionBesoinItemService(ExpressionBesoinItemService expressionBesoinItemService) {
        this.expressionBesoinItemService = expressionBesoinItemService;
    }

    public AbstractConverter<ExpressionBesoinItem, ExpressionBesoinItemVo> getExpressionBesoinItemConverter() {
        return expressionBesoinItemConverter;
    }

    public void setExpressionBesoinItemConverter(AbstractConverter<ExpressionBesoinItem, ExpressionBesoinItemVo> expressionBesoinItemConverter) {
        this.expressionBesoinItemConverter = expressionBesoinItemConverter;
    }
    
    
    
}
