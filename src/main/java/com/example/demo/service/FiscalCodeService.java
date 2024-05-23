package com.example.demo.service;

import com.example.demo.exception.InvalidFiscalCodeException;
import com.example.demo.model.Info;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class FiscalCodeService {

    public Info getInfo(String fiscal) {

        //controllo che non mi manda in eccezione se scrivo il codice fiscale in m invece che M
        String fiscalCode = fiscal.toUpperCase();

        Info info = new Info();

        //check fiscalCode is valid
        if (isValidCodiceFiscale(fiscalCode)) {

            //calculate dateBirth
            LocalDate birthDate = extractBirthDate(fiscalCode);

            //calculate age
            int age = Period.between(birthDate, LocalDate.now()).getYears();

            info.setDateBirth(birthDate);
            info.setAge(age);
            return info;
        }
        {
            throw new InvalidFiscalCodeException("Il formato del codice fiscale " + fiscalCode + " non è valido");
        }

    }

    private boolean isValidCodiceFiscale(String codiceFiscale) {

        final String CODICE_FISCALE_REGEX = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$";

        if (codiceFiscale == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(CODICE_FISCALE_REGEX);
        Matcher matcher = pattern.matcher(codiceFiscale);
        return matcher.matches();
    }

    private LocalDate extractBirthDate(String fiscalCode) {

        String yearStr = fiscalCode.substring(6, 8);
        String monthStr = fiscalCode.substring(8, 9);
        String dayStr = fiscalCode.substring(9, 11);

        // se il giorno è > 40 il codice è di una donna;
        // quindi per avere il giorno esatto  - 40
        int day = Integer.parseInt(dayStr);
        if (day > 40) {
            day -= 40;
        }

        // calcolo del mese
        int month;
        switch (monthStr) {
            case "A":
                month = 1;
                break;
            case "B":
                month = 2;
                break;
            case "C":
                month = 3;
                break;
            case "D":
                month = 4;
                break;
            case "E":
                month = 5;
                break;
            case "H":
                month = 6;
                break;
            case "L":
                month = 7;
                break;
            case "M":
                month = 8;
                break;
            case "P":
                month = 9;
                break;
            case "R":
                month = 10;
                break;
            case "S":
                month = 11;
                break;
            case "T":
                month = 12;
                break;
            default:
                throw new IllegalArgumentException("Mese non valido nel codice fiscale");
        }

        //calcolo anno considerando range 1925 e 2024
        int year = Integer.parseInt(yearStr);
        year = year > 25 ? 1900 + year : 2000 + year;

        return LocalDate.of(year, month, day);
    }

}
