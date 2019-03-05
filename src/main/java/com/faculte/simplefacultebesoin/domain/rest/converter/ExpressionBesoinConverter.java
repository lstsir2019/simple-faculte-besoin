/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.rest.converter;


import ch.qos.logback.core.pattern.ConverterUtil;
import com.faculte.simplefacultebesoin.commun.util.DateUtil;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoin;
import com.faculte.simplefacultebesoin.domain.rest.vo.ExpressionBesoinVo;
import com.sun.jmx.snmp.daemon.CommunicatorServer;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author ismail boulaanait
 */
@Component
public class ExpressionBesoinConverter extends AbstractConverter<ExpressionBesoin, ExpressionBesoinVo>{

    @Override
    public ExpressionBesoin toItem(ExpressionBesoinVo vo) {
        if(vo!=null){
           ExpressionBesoin expressionBesoin= new ExpressionBesoin();
           expressionBesoin.setId(vo.getId());
           expressionBesoin.setReference(vo.getReference());
           expressionBesoin.setCodeEntity(vo.getCodeEntity());
           expressionBesoin.setCodePersonel(vo.getCodePersonel());
           expressionBesoin.setDateExpression(DateUtil.parseDate(vo.getDateExpression()));
           expressionBesoin.setExpressionBesoinItems(new ExpressionBesoinItemConverter().toItem(vo.getExpressionBesoinItemsVos()));
           return expressionBesoin;
        }
        return null;
    }

    @Override
    public ExpressionBesoinVo toVo(ExpressionBesoin item) {
        
       if(item==null){
        return null;
       }else{
           ExpressionBesoinVo vo = new ExpressionBesoinVo();
           vo.setId(item.getId());
           vo.setReference(item.getReference());
           vo.setCodeEntity(item.getCodeEntity());
           vo.setCodePersonel(item.getCodePersonel());
           vo.setDateExpression(DateUtil.formateDate(item.getDateExpression()));
           vo.setExpressionBesoinItemsVos(new ExpressionBesoinItemConverter().toVo(item.getExpressionBesoinItems()));
           return vo;
       }
    }
    
}