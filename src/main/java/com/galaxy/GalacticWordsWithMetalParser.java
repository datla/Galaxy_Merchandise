package com.galaxy;

import static org.apache.commons.lang.StringUtils.substringAfterLast;
import static org.apache.commons.lang.StringUtils.substringBeforeLast;

public class GalacticWordsWithMetalParser {

    //TODO need to split by considering multiple spaces
    public static String parseGalacticWords(String input) {
        return substringBeforeLast(input, " ");
    }

    public static String parseMetalName(String input) {
        return substringAfterLast(input, " ");
    }

}
