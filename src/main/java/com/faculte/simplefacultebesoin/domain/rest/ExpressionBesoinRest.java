/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultebesoin.domain.rest;

import com.faculte.simplefacultebesoin.commun.util.DateUtil;
import com.faculte.simplefacultebesoin.commun.util.GeneratePdf;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoin;
import com.faculte.simplefacultebesoin.domain.bean.ExpressionBesoinItem;
import com.faculte.simplefacultebesoin.domain.model.service.ExpressionBesoinItemService;
import com.faculte.simplefacultebesoin.domain.model.service.ExpressionBesoinService;
import com.faculte.simplefacultebesoin.domain.rest.converter.AbstractConverter;
import com.faculte.simplefacultebesoin.domain.rest.converter.ExpressionBesoinItemConverter;
import com.faculte.simplefacultebesoin.domain.rest.proxy.ProduitProxy;
import com.faculte.simplefacultebesoin.domain.rest.vo.ExpressionBesoinItemVo;
import com.faculte.simplefacultebesoin.domain.rest.vo.ExpressionBesoinVo;
import com.faculte.simplefacultebesoin.domain.rest.vo.exchange.CategorieProduitVo;
import com.faculte.simplefacultebesoin.domain.rest.vo.exchange.ProduitVo;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ismail boulaanait
 */
@RestController()
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping({"/faculte-besoin/expressionbesoins"})
public class ExpressionBesoinRest {

    @Autowired
    ProduitProxy produitProxy;

    @Autowired
    ExpressionBesoinService expressionBesoinService;

    @Autowired
    ExpressionBesoinItemService expressionBesoinItemService;

    @Autowired
    @Qualifier("expressionBesoinConverter")
    private AbstractConverter<ExpressionBesoin, ExpressionBesoinVo> expressionBesoinConverter;

    @Autowired
    @Qualifier("expressionBesoinItemConverter")
    private AbstractConverter<ExpressionBesoinItem, ExpressionBesoinItemVo> expressionBesoinItemConverter;

    @PostMapping("/")
    public int create(@RequestBody ExpressionBesoinVo expressionBesoinVo) {
        ExpressionBesoin eb = expressionBesoinConverter.toItem(expressionBesoinVo);
        return expressionBesoinService.create(eb);
    }

    @GetMapping("/reference/{reference}")
    public ExpressionBesoinVo findByReference(@PathVariable String reference) {
        ExpressionBesoin eb = expressionBesoinService.findByReference(reference);
        return expressionBesoinConverter.toVo(eb);
    }

    @GetMapping("/items/{reference}")
    public List<ExpressionBesoinItemVo> findByExpressionBesoinReference(@PathVariable String reference) {
        List<ExpressionBesoinItem> res = expressionBesoinItemService.findByExpressionBesoinReference(reference);
        return new ExpressionBesoinItemConverter().toVo(res);
    }

    @GetMapping("/")
    public List<ExpressionBesoinVo> findAll() {
        return expressionBesoinConverter.toVo(expressionBesoinService.findAll());
    }

    @PostMapping("/search")
    public List<ExpressionBesoinVo> findByCriteria(@RequestBody ExpressionBesoinVo expressionBesoin) {
        Date dateMin = DateUtil.parseDate(expressionBesoin.getDateMin());
        Date dateMax = DateUtil.parseDate(expressionBesoin.getDateMax());
        return expressionBesoinConverter.toVo(expressionBesoinService.findByCriteria(expressionBesoin.getReference(), expressionBesoin.getCodeEntity(), dateMin, dateMax));
    }

    @GetMapping("/categorieProduit")
    public List<CategorieProduitVo> getAll() {
        return produitProxy.findAll();
    }

    @GetMapping("/Produit/categorie/{libelle}")
    public List<ProduitVo> findByCategorieProduitLibelle(@PathVariable String libelle) {
        return produitProxy.findByCategorieProduitLibelle(libelle);
    }

    
    @GetMapping("/pdf/reference/{reference}")
    public ResponseEntity<Object> CommandePrint(@PathVariable String reference) throws JRException, IOException {
        ExpressionBesoin c = expressionBesoinService.findByReference(reference);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("reference", c.getReference());
        parameters.put("date", c.getDateExpression());
        parameters.put("codeEntity", c.getCodeEntity());
        parameters.put("codePersonel", c.getCodePersonel());

        return GeneratePdf.generate("expression besoin", parameters, expressionBesoinItemService.findByExpressionBesoinReference(reference), "/report/besoin.jasper");
    }
    public AbstractConverter<ExpressionBesoin, ExpressionBesoinVo> getExpressionBesoinConverter() {
        return expressionBesoinConverter;
    }

    public void setExpressionBesoinConverter(AbstractConverter<ExpressionBesoin, ExpressionBesoinVo> expressionBesoinConverter) {
        this.expressionBesoinConverter = expressionBesoinConverter;
    }

    public ExpressionBesoinService getExpressionBesoinService() {
        return expressionBesoinService;
    }

    public void setExpressionBesoinService(ExpressionBesoinService expressionBesoinService) {
        this.expressionBesoinService = expressionBesoinService;
    }

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

    public ProduitProxy getProduitProxy() {
        return produitProxy;
    }

    public void setProduitProxy(ProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }

    
    
}
