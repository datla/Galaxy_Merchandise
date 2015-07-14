package com.galaxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.substringAfterLast;
import static org.apache.commons.lang.StringUtils.substringBeforeLast;

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

            //TODO need to split by considering multiple spaces
            metalName = substringAfterLast(galacticWordsWithMetalName, " ");
            galacticWords = substringBeforeLast(galacticWordsWithMetalName, " ");
        }

        return new MetalCreditsLine(galacticWords, metalName, credits);
    }
}
