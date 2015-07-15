package com.galaxy.output;

import com.galaxy.business.RomanToDecimalConverter;
import com.galaxy.input.GalacticToRomanConverter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GalacticQuestionHandler implements Handler {

    private final GalacticToRomanConverter galacticToRomanConverter;
    private final RomanToDecimalConverter romanToDecimalConverter;

    public GalacticQuestionHandler(GalacticToRomanConverter galacticToRomanConverter,
            RomanToDecimalConverter romanToDecimalConverter) {
        this.galacticToRomanConverter = galacticToRomanConverter;
        this.romanToDecimalConverter = romanToDecimalConverter;
    }

    @Override
    public boolean canHandle(String question) {
        return question.matches("^how much is .*");
    }

    @Override
    public String findAnswer(String question) {
        String galacticWords = QuestionParser.parseGalacticWords(question);
        String romanNumberString = galacticToRomanConverter.convert(galacticWords);
        int decimalNumber = romanToDecimalConverter.convert(romanNumberString);

        return AnswerFormatter.fromat(galacticWords, decimalNumber);
    }

    private static class QuestionParser{
        private static final Pattern galacticQuestionPattern = Pattern.compile("^how much is (.*) \\?$");

        static String parseGalacticWords(String question){
            Matcher matcher = galacticQuestionPattern.matcher(question);
            return matcher.find() ?  matcher.group(1) : "";
        }
    }

    private static class AnswerFormatter {
        private static final String formatPattern = "%s is %s";

        static String fromat(String galacticWords, int decimalNumber){
            return String.format(formatPattern, galacticWords, String.valueOf(decimalNumber));
        }
    }
}
