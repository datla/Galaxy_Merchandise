package com.galaxy;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_CEILING;

public class MetalCreditsCalculator {

    private final GalacticToRomanConverter galacticToRomanConverter;
    private final RomanToDecimalConverter romanToDecimalConverter;

    public MetalCreditsCalculator(GalacticToRomanConverter galacticToRomanConverter,
            RomanToDecimalConverter romanToDecimalConverter) {

        this.galacticToRomanConverter = galacticToRomanConverter;
        this.romanToDecimalConverter = romanToDecimalConverter;
    }

    public BigDecimal calculateCredits(MetalCreditsLine metalCreditsLine) {
        String noOfMetalRoman = galacticToRomanConverter.convert(metalCreditsLine.galacticWords());
        long noOfMetals = romanToDecimalConverter.convert(noOfMetalRoman);
        
        BigDecimal credits = new BigDecimal(metalCreditsLine.credits()).divide(BigDecimal.valueOf(noOfMetals))
                .setScale(2, ROUND_CEILING);
        
        return credits;
    }
}
