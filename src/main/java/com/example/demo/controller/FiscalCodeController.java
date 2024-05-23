package com.example.demo.controller;

import com.example.demo.exception.InvalidFiscalCodeException;
import com.example.demo.model.Info;
import com.example.demo.service.FiscalCodeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fiscalCode")
public class FiscalCodeController {

    public FiscalCodeService fiscalCodeService;

    @Autowired
    public FiscalCodeController(FiscalCodeService fiscalCodeService) {
        this.fiscalCodeService = fiscalCodeService;
    }

    /**
     * Esporre un api rest in spring boot che dato un codice fiscale restituisca data di nascita ed età.
     * Il tutto interrogabile da swagger
     **/

    @ApiOperation(value = "Calcolo data di nascita ed età",
            notes = "dato un codice fiscale restituisca data di nascita ed età", response = Info.class,
            produces = "application/json")
    @GetMapping("/getInfo")
    public ResponseEntity<Info> getInfo(@RequestParam String fiscalCode) {
        return ResponseEntity.ok(fiscalCodeService.getInfo(fiscalCode));
    }

    /**
     * eccezione che viene sollevata in caso di codice fiscale non è valido ovvero che non soddisfa la regex
     **/
    @ExceptionHandler(InvalidFiscalCodeException.class)
    public ResponseEntity<String> handleInvalidFiscalCodeException(InvalidFiscalCodeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
