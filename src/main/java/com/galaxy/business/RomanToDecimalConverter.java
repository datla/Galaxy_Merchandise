package com.galaxy.business;

import com.galaxy.datatypes.RomanNumber;

import static com.galaxy.datatypes.RomanNumber.newRomanNumber;

public class RomanToDecimalConverter {

    private final RomanNumberValidator romanNumberValidator;

    public RomanToDecimalConverter(RomanNumberValidator romanNumberValidator) {
        this.romanNumberValidator = romanNumberValidator;
    }

    //TODO can be done in a recursive way, may not be readable though
    public int convert(String romanStr){

        //TODO throw custom/business exception if there is requirement on what needs to be done when given roman number is invalid
        if(!romanNumberValidator.isValid(romanStr)){
            throw new IllegalArgumentException("Given roman number is not valid:" + romanStr);
        }

        int decimalNumber = 0;
        char[] romanChars = romanStr.toCharArray();

        RomanNumber previousNumber = newRomanNumber(String.valueOf(romanChars[romanChars.length - 1]));
        decimalNumber += previousNumber.decimalValue();
        // QUESTION ?
        for(int i=romanChars.length-2; i>=0; i--) {
            RomanNumber currentRomanNumber = newRomanNumber(String.valueOf(romanChars[i]));
            if(currentRomanNumber.decimalValue() < previousNumber.decimalValue()){
                decimalNumber -= currentRomanNumber.decimalValue();
            }else{
                decimalNumber += currentRomanNumber.decimalValue();
            }

            previousNumber = currentRomanNumber;
        }

        return decimalNumber;
    }
}
