package com.galaxy.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumberValidator {

    //TODO create separate validation rules
    //TODO subtraction validation logic can be written in multiple ways, change enum signature which takes invalid characters and then traverse the string to check the right side character validity
    private static  final Pattern invalidPattern = Pattern.compile("I{4,}|X{4,}|C{4,}|M{4,}|D{2,}|L{2,}|V{2,}|I[LCDM]|X[VDM]|V[XLCDM]|L[CDM]|D[M]");
    // RAJAQ - Explain the regular expression here.
    
    public boolean isValid(String romanStr){
        boolean isValid = true;

        Matcher matcher = invalidPattern.matcher(romanStr);
        if(matcher.find()){
            isValid = false;
        }

        return isValid;
    }
}
