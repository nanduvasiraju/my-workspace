package com.ws.test.utils;

import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.ws.test.model.Range;
import com.ws.test.utils.ZipRangeUtil;

/**
 * Class containing tests for RangeUtils Class
 * 
 * @author RVASIRAJ
 * @version 1.0
 *
 */
public class RangeUtilsTest {

    /**
     * Test to validate if a formatted input range is converted to String array
     */
    @Test
    public void testGetRange() {
        String input = "[20000,30000]";
        String[] range = ZipRangeUtil.getRange(input);
        Assert.assertEquals("20000", range[0]);
        Assert.assertEquals("30000", range[1]);
    }

    /**
     * Test to validate if formatted string is returned
     */
    @Test
    public void testGetFormattedString() {
        String result = ZipRangeUtil.getFormattedStringRange("34632", "00456");
        Assert.assertEquals("[00456,34632]", result);
    }

    /**
     * Test to validate if the list is converted into a sorted map
     */
    @Test
    public void testGetSortedMap() {
        Map<Integer, Range> sortedMap = ZipRangeUtil
                .getSortedMap(ZipRangeUtil.getInputRange());
        Iterator<Integer> mapIte = sortedMap.keySet().iterator();
        int key = mapIte.next();
        Assert.assertEquals(key, 94133);
    }

}
