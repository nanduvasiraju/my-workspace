package com.ws.test.model;

/**
 * Model for the range object that contains values for lower and upper bound of ranges
 * 
 * @author RVASIRAJ
 *
 */
public class Range {

    private String strLowerBound; 
    private String strUpperBound; 
    private int lowerBound;
    private int upperBound;
    private String range;

    public Range(String range) {
        this.range = range;
        this.strLowerBound = range.substring(1, 6);
        this.strUpperBound = range.substring(7, 12);
        this.lowerBound = Integer.valueOf(this.strLowerBound);
        this.upperBound = Integer.valueOf(this.strUpperBound);
    }

    /**
     * @return the strUpperBound
     */
    public String getStrUpperBound() {
        return strUpperBound;
    }

    /**
     * @return the lowerBound
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * @return the upperBound
     */
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * @return the strLowerBound
     */
    public String getStrLowerBound() {
        return strLowerBound;
    }

    /**
     * @return the range
     */
    public String getRange() {
        return range;
    }

}
