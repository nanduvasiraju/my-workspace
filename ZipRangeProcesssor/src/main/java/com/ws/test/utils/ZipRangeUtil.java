package com.ws.test.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ws.test.model.Range;

/**
 * Helper/Utility class for the ZIP range optimizer application.
 * 
 * @author RVASIRAJ
 *
 */
public class ZipRangeUtil {

    /**
     * Utility method to convert a String based input range into an array
     * 
     * @param inputRange
     *            String input range
     * @return Array version of that input range
     */
    public static String[] getRange(String inputRange) {
        String[] range = new String[2];
        range[0] = inputRange.substring(1, 6);
        range[1] = inputRange.substring(7, 12);
        return range;
    }

    /**
     * Utility method to convert a given set of range numbers into a formatted
     * range
     * 
     * @param highRange
     *            High end of the range yyyyy
     * @param lowRange
     *            Low end of the range xxxxx
     * @return formatted String of the range [xxxxx,yyyyy]
     */
    public static String getFormattedStringRange(String highRange,
            String lowRange) {
        String range = ZipAppConstants.RANGE_START + lowRange
                + ZipAppConstants.SEPARATOR + highRange
                + ZipAppConstants.RANGEE_END;

        return range;
    }

    /**
     * Utility method to return a map, whose keys are sorted based on lower ranges
     * 
     * @param list
     *            Input list of ranges
     * @return Map Integer keys sorted based on lower bound range and value as
     *         Range Objects
     */
    public static Map<Integer, Range> getSortedMap(List<String> list) {
        Map<Integer, Range> sortedMap = new TreeMap<>();
        for (String range : list) {
            Range obj = new Range(range);
            sortedMap.put(obj.getLowerBound(), obj);
        }

        return sortedMap;
    }

    /**
     * Utility method to construct the input where each entry is one set of range
     * set
     * 
     * @return List which acts as the input to the client
     */

    public static List<String> getInputRange() {
        List<String> input = new ArrayList<>();
        input.add("[95630,95656]");
        input.add("[95760,95800]");
        input.add("[95620,95699]");
        input.add("[94133,94133]");
        input.add("[94200,94299]");
        input.add("[94226,94399]");

        return input;

    }
}
