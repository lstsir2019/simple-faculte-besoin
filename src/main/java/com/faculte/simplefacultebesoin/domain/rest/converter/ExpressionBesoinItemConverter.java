/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.rest.converter;


import com.faculte.simplefacultebesoin.commun.util.NumberUtil;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoinItem;
import com.faculte.simplefacultebesoin.domain.rest.vo.ExpressionBesoinItemVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author ismail boulaanait
 */
@Component
public class ExpressionBesoinItemConverter extends AbstractConverter<ExpressionBesoinItem, ExpressionBesoinItemVo> {

    @Override
    public ExpressionBesoinItem toItem(ExpressionBesoinItemVo vo) {
        if (vo == null) {
            return null;
        } else {
            ExpressionBesoinItem item = new ExpressionBesoinItem();
            item.setId(vo.getId());
            item.setDescription(vo.getDescription());
            item.setQuantiteAccorder(NumberUtil.toInteger(vo.getQuantiteAccorder()));
            item.setQuantiteCommander(NumberUtil.toInteger(vo.getQuantiteCommander()));
            item.setQuantiteDemande(NumberUtil.toInteger(vo.getQuantiteDemande()));
            item.setQuantiteLivre(NumberUtil.toInteger(vo.getQuantiteLivre()));
            item.setReferenceProduit(vo.getReferenceProduit());
            item.setReferenceCategorieProduit(vo.getReferenceCategorieProduit());
            return item;
        }
    }

    @Override
    public ExpressionBesoinItemVo toVo(ExpressionBesoinItem item) {

        if (item == null) {
            return null;
        } else {
            ExpressionBesoinItemVo vo = new ExpressionBesoinItemVo();
            vo.setId(item.getId());
            vo.setDescription(item.getDescription());
            vo.setQuantiteAccorder(NumberUtil.inttoString(item.getQuantiteAccorder()));
            vo.setQuantiteCommander(NumberUtil.inttoString(item.getQuantiteCommander()));
            vo.setQuantiteDemande(NumberUtil.inttoString(item.getQuantiteDemande()));
            vo.setQuantiteLivre(NumberUtil.inttoString(item.getQuantiteLivre()));
            vo.setReferenceProduit(item.getReferenceProduit());
            vo.setReferenceCategorieProduit(item.getReferenceCategorieProduit());

            return vo;
        }
    }

}
