package com.example.demo.controller;

import com.example.demo.model.DateBirthAndAge;
import com.example.demo.model.InputFiscalCode;
import com.example.demo.service.FiscalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fiscalCode")
public class FiscalCodeController {

    public FiscalCodeService fiscalCodeService;

    @Autowired
    public FiscalCodeController(FiscalCodeService fiscalCodeService){
        this.fiscalCodeService = fiscalCodeService;
    }

    /**
     * Esporre un api rest in spring boot che dato un codice fiscale restituisca data di nascita ed età.
     * Il tutto interrogabile da swagger
     **/
    @GetMapping("/getInfo")
    public DateBirthAndAge getInfo (@RequestParam InputFiscalCode fiscalCode){
     return fiscalCodeService.getInfo(fiscalCode);
    }
}
