package com.galaxy.business;

import com.galaxy.business.MetalCreditsCalculator;
import com.galaxy.business.RomanToDecimalConverter;
import com.galaxy.input.GalacticToRomanConverter;
import com.galaxy.input.MetalCreditsLine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MetalCreditsCalculatorTest {

    @Mock
    private GalacticToRomanConverter mockGalacticToRomanConverter;
    @Mock
    private RomanToDecimalConverter mockRomanToDecimalConverter;

    private MetalCreditsCalculator metalCreditsCalculator;

    @Before
    public void setUp(){
        metalCreditsCalculator = new MetalCreditsCalculator(mockGalacticToRomanConverter, mockRomanToDecimalConverter);
    }

    //TODO: Document assumption precision rounded to 2 digits
    @Test
    public void calculateCredits_should_return_valid_credits_value() throws Exception {
        MetalCreditsLine metalCreditsLine = new MetalCreditsLine("pish pish", "Iron", "3910");
        when(mockGalacticToRomanConverter.convert("pish pish")).thenReturn("XX");
        when(mockRomanToDecimalConverter.convert("XX")).thenReturn(20L);

        BigDecimal credits = metalCreditsCalculator.calculateCredits(metalCreditsLine);
        assertThat(credits.toString(), is("195.50"));
    }
}
