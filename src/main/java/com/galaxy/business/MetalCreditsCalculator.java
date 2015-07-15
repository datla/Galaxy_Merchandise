package com.galaxy.business;

import com.galaxy.input.GalacticToRomanConverter;
import com.galaxy.input.MetalCreditsLine;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_FLOOR;

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
        int noOfMetals = romanToDecimalConverter.convert(noOfMetalRoman);
        
        BigDecimal credits = new BigDecimal(metalCreditsLine.credits()).divide(BigDecimal.valueOf(noOfMetals))
                .setScale(2, ROUND_FLOOR);
        
        return credits;
    }
}
