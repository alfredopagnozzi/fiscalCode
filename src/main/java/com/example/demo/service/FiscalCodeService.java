package com.example.demo.service;

import com.example.demo.model.DateBirthAndAge;
import com.example.demo.model.InputFiscalCode;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class FiscalCodeService {

    public DateBirthAndAge getInfo(InputFiscalCode input) {
        //check fiscalCode is valid
        DateBirthAndAge dateBirthAndAge = new DateBirthAndAge();
        if (isValidCodiceFiscale(input.getFiscalCode())) {
            System.out.println(input.getFiscalCode() + " è un codice fiscale valido.");
            //calculate dateBirth

            //calculate age
            return dateBirthAndAge;
        } else {
            System.out.println("il formato del codice fiscale " + input.getFiscalCode() + " non e' valido");
          return dateBirthAndAge;
        }

    }

    public static boolean isValidCodiceFiscale(String codiceFiscale) {
        String CODICE_FISCALE_REGEX = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$";
        if (codiceFiscale == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(CODICE_FISCALE_REGEX);
        Matcher matcher = pattern.matcher(codiceFiscale);
        return matcher.matches();
    }
}
