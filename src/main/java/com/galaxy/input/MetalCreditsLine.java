package com.galaxy.input;

//TODO Add builder to have readable way of building this object
public class MetalCreditsLine {

    private final String galacticWords;
    private final String metalName;
    private final String creditsValue;

    public MetalCreditsLine(String galacticWords, String metalName, String creditsValue) {
        this.galacticWords = galacticWords;
        this.metalName = metalName;
        this.creditsValue = creditsValue;
    }

    public String galacticWords() {
        return galacticWords;
    }

    public String metalName() {
        return metalName;
    }

    public String credits() {
        return creditsValue;
    }
}
