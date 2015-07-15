package com.galaxy.business;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RomanNumberValidatorTest {

    @Test
    public void isValid_false_given_more_successive_occurrence_than_allowed() throws Exception {

        RomanNumberValidator romanNumberValidator = new RomanNumberValidator();
        assertFalse(romanNumberValidator.isValid("XXXX"));
        assertFalse(romanNumberValidator.isValid("IIII"));
        assertFalse(romanNumberValidator.isValid("CCCC"));
        assertFalse(romanNumberValidator.isValid("MMMM"));
        assertFalse(romanNumberValidator.isValid("DD"));
        assertFalse(romanNumberValidator.isValid("LL"));
        assertFalse(romanNumberValidator.isValid("VV"));
        assertFalse(romanNumberValidator.isValid("IXXXICCCC"));
    }

    @Test
    public void isValid_true_given_less_successive_occurrence_than_allowed() throws Exception {

        RomanNumberValidator romanNumberValidator = new RomanNumberValidator();
        assertTrue(romanNumberValidator.isValid("XXX"));
        assertTrue(romanNumberValidator.isValid("II"));
        assertTrue(romanNumberValidator.isValid("C"));
        assertTrue(romanNumberValidator.isValid("MMM"));
        assertTrue(romanNumberValidator.isValid("D"));
        assertTrue(romanNumberValidator.isValid("L"));
        assertTrue(romanNumberValidator.isValid("V"));
        assertTrue(romanNumberValidator.isValid("IXXXCCC"));
    }

    @Test
     public void isValid_false_given_invalid_subtraction_combination() throws Exception {

        RomanNumberValidator romanNumberValidator = new RomanNumberValidator();
        assertFalse(romanNumberValidator.isValid("IL"));
        assertFalse(romanNumberValidator.isValid("IC"));
        assertFalse(romanNumberValidator.isValid("ID"));
        assertFalse(romanNumberValidator.isValid("IM"));

        assertFalse(romanNumberValidator.isValid("XV"));
        assertFalse(romanNumberValidator.isValid("XD"));
        assertFalse(romanNumberValidator.isValid("XM"));

        assertFalse(romanNumberValidator.isValid("VX"));
        assertFalse(romanNumberValidator.isValid("VL"));
        assertFalse(romanNumberValidator.isValid("VC"));
        assertFalse(romanNumberValidator.isValid("VD"));
        assertFalse(romanNumberValidator.isValid("VM"));

        assertFalse(romanNumberValidator.isValid("LC"));
        assertFalse(romanNumberValidator.isValid("LD"));
        assertFalse(romanNumberValidator.isValid("LM"));

        assertFalse(romanNumberValidator.isValid("DM"));
    }

    @Test
    public void isValid_false_given_valid_combination() throws Exception {

        RomanNumberValidator romanNumberValidator = new RomanNumberValidator();
        assertTrue(romanNumberValidator.isValid("IV"));
        assertTrue(romanNumberValidator.isValid("IX"));

        assertTrue(romanNumberValidator.isValid("XL"));
        assertTrue(romanNumberValidator.isValid("XC"));

        assertTrue(romanNumberValidator.isValid("CD"));
        assertTrue(romanNumberValidator.isValid("CM"));

        assertTrue(romanNumberValidator.isValid("VI"));

        assertTrue(romanNumberValidator.isValid("LI"));
        assertTrue(romanNumberValidator.isValid("LV"));
        assertTrue(romanNumberValidator.isValid("LX"));

        assertTrue(romanNumberValidator.isValid("DI"));
        assertTrue(romanNumberValidator.isValid("DV"));
        assertTrue(romanNumberValidator.isValid("DX"));
        assertTrue(romanNumberValidator.isValid("DL"));
        assertTrue(romanNumberValidator.isValid("DC"));
    }

}
