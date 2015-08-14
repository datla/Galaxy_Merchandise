package com.galaxy.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.galaxy.GalacticWordsWithMetalStringParser.parseGalacticWords;
import static com.galaxy.GalacticWordsWithMetalStringParser.parseMetalName;

public class MetalCreditsLineParser {
    private static final Pattern creditsPattern = Pattern.compile("^(.*)\\s+is\\s(.*)\\s+Credits$");

    public MetalCreditsLine parse(String input) {
        String galacticWords = "";
        String metalName = "";
        String credits = "";
        Matcher matcher = creditsPattern.matcher(input);
        if(matcher.find()){
            String galacticWordsWithMetalName = matcher.group(1);
            credits = matcher.group(2);
            metalName = parseMetalName(galacticWordsWithMetalName);
            galacticWords = parseGalacticWords(galacticWordsWithMetalName);
        }
        return new MetalCreditsLine(galacticWords, metalName, credits);
    }
    
}
