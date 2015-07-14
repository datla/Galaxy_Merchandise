package com.galaxy.output;

import com.galaxy.business.RomanToDecimalConverter;
import com.galaxy.input.GalacticToRomanConverter;
import com.galaxy.input.MetalCreditsStore;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.galaxy.GalacticWordsWithMetalParser.parseGalacticWords;
import static com.galaxy.GalacticWordsWithMetalParser.parseMetalName;
import static com.galaxy.datatypes.Metal.newMetal;
import static java.math.BigDecimal.ROUND_CEILING;
import static java.math.BigDecimal.ROUND_FLOOR;

public class MetalCreditsQuestionHandler implements Handler {

    private final MetalCreditsStore metalCreditsStore;
    private GalacticToRomanConverter galacticToRomanConverter;
    private RomanToDecimalConverter romanToDecimalConverter;

    public MetalCreditsQuestionHandler(MetalCreditsStore metalCreditsStore,
            GalacticToRomanConverter galacticToRomanConverter,
            RomanToDecimalConverter romanToDecimalConverter) {

        this.metalCreditsStore = metalCreditsStore;
        this.galacticToRomanConverter = galacticToRomanConverter;
        this.romanToDecimalConverter = romanToDecimalConverter;
    }

    @Override
    public boolean canHandle(String question) {
        return question.matches("^how many Credits is .*");
    }

    @Override
    public String findAnswer(String question) {
        String galacticWordsWithMetal = new QuestionParser().parseGalacticWordsWithMetal(question);

        String metalName = parseMetalName(galacticWordsWithMetal);
        String galacticWords = parseGalacticWords(galacticWordsWithMetal);

        //TODO push this calculation logic to MetalCreditsCalculator
        String noOfMetalsRomanStr = galacticToRomanConverter.convert(galacticWords);
        long noOfMetals = romanToDecimalConverter.convert(noOfMetalsRomanStr);

        BigDecimal metalCredits = metalCreditsStore.getCredits(newMetal(metalName));
        BigDecimal totalCredits = new BigDecimal(noOfMetals).multiply(metalCredits).setScale(2, ROUND_FLOOR).stripTrailingZeros();

        return new AnswerFormatter().fromat(galacticWordsWithMetal, totalCredits);
    }

    private static class QuestionParser{
        private static final Pattern metalCreditsQuestionPattern = Pattern.compile("^how many Credits is (.*) \\?$");

        String parseGalacticWordsWithMetal(String question){
            Matcher matcher = metalCreditsQuestionPattern.matcher(question);
            return matcher.find() ?  matcher.group(1) : "";
        }
    }

    private static class AnswerFormatter {
        private static final String formatPattern = "%s is %s Credits";

        String fromat(String galacticWordsWithMetal, BigDecimal totalCredits){
            return String.format(formatPattern, galacticWordsWithMetal, totalCredits.toString());
        }
    }
}
