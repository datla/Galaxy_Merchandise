package com.galaxy.input;

import com.galaxy.business.MetalCreditsCalculator;

import java.math.BigDecimal;

import static com.galaxy.datatypes.Metal.newMetal;

public class MetalCreditsProcessor implements Processor {

    private final MetalCreditsStore metalCreditsStore;
    private final MetalCreditsLineParser metalCreditsLineParser;
    private MetalCreditsCalculator metalCreditsCalculator;

    public MetalCreditsProcessor(MetalCreditsStore metalCreditsStore,
            MetalCreditsLineParser metalCreditsLineParser,
            MetalCreditsCalculator metalCreditsCalculator) {
        this.metalCreditsStore = metalCreditsStore;
        this.metalCreditsLineParser = metalCreditsLineParser;
        this.metalCreditsCalculator = metalCreditsCalculator;
    }

    @Override
    public boolean canProcess(String input) {
        return input.matches("^.*Credits$");
    }

    @Override
    public void process(String input) {
        MetalCreditsLine metalCreditsLine = metalCreditsLineParser.parse(input);
        BigDecimal credits = metalCreditsCalculator.calculateCredits(metalCreditsLine);
        metalCreditsStore.addMetal(newMetal(metalCreditsLine.metalName()), credits);
    }
}
