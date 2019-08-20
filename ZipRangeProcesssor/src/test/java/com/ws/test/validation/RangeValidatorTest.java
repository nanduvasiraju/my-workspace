package com.ws.test.validation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ws.test.utils.ZipErrorConstants;
import com.ws.test.validation.RangeValidator;

/**
 * Class containing tests for RangeValidator Class
 * 
 * @author RVASIRAJ
 * @version 1.0
 *
 */

public class RangeValidatorTest {
    
    /**
     * Test to check for valid input with leading zeroes
     */
    @Test
    public void testValidInputLeadingZeroInRange() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[01234,12345]");
        try {
            boolean result = validator.isValid(input);
            Assert.assertEquals(true, result);
        } catch (IllegalArgumentException ife) {
            Assert.fail();
        }
    }
    

    /**
     * Test to check for invalid input with a space in between range values
     */
    @Test
    public void testInValidInputSpace() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[956300, 95762]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ZipErrorConstants.ERROR_CODE_002_MSG,
                    ex.getMessage());
        }
    }
    
    /**
     * Test to check for invalid input with no range values passed
     */
    @Test
    public void testInValidInputNoInputProvided() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ZipErrorConstants.ERROR_CODE_001_MSG,
                    ex.getMessage());
        }
    }    

    /**
     * Test to check for invalid input with a non integer number in lower range
     */
    @Test
    public void testInValidInputLowerRange() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[9576A,95770]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ZipErrorConstants.ERROR_CODE_002_MSG,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with a non integer number in higher range
     */
    @Test
    public void testInValidInputUpperRange() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[95852,9589Z]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ZipErrorConstants.ERROR_CODE_002_MSG,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with special characters in lower/upper
     * range
     */
    @Test
    public void testInValidInputSpecialCharacters() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[9589A,9589$]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ZipErrorConstants.ERROR_CODE_002_MSG,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with flower brackets
     */
    @Test
    public void testInValidInputNoSquareBrackets() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("{25891,87961}");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ZipErrorConstants.ERROR_CODE_002_MSG,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with no range values
     */
    @Test
    public void testInValidInputNoRangeProvided() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ZipErrorConstants.ERROR_CODE_002_MSG,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with 4 digit zip code
     */
    @Test
    public void testInValidInputFourDigitZipCode() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[9563,95615]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ZipErrorConstants.ERROR_CODE_002_MSG,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with no range values passed
     */
    @Test
    public void testInValidInputOneRangeInvalidMultiInput() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[95679,95715]");
        input.add("[99800, 99900]");
        input.add("[95500,95579]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ZipErrorConstants.ERROR_CODE_002_MSG,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with no range values passed
     */
    @Test
    public void testValidInput() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[49679,52015]");
        input.add("[49800,50000]");
        input.add("[51500,53479]");
        try {
            boolean result = validator.isValid(input);
            Assert.assertEquals(true, result);
        } catch (IllegalArgumentException ex) {
            Assert.fail();
        }
    }

    /**
     * Test to check for invalid input with no range values passed
     */
    @Test
    public void testInValidInputLowerBoundBiggerThanUpperBound() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[98999,98888]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ZipErrorConstants.ERROR_CODE_003_MSG,
                    ex.getMessage());
        }
    }    

}
