package com.ws.test.optimizer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ws.test.optimizer.RangeOptimizer;
import com.ws.test.utils.ZipRangeUtil;

/**
 * 
 * Class containing tests for RangeOptimizer Class
 * 
 * @author RVASIRAJ
 * @version 1.0
 *
 */
public class RangeOptimizerTest {

    /**
     * Test to check optimizing algorithm when ranges over overlapping
     */
    @Test
    public void testOptimizeRangesWithOverlapping() {
        List<String> input = new ArrayList<>();

        input.add("[20001,25000]");
        input.add("[24000,25673]");
        input.add("[30000,34562]");
        input.add("[45234,65498]");

        RangeOptimizer optimizer = new RangeOptimizer();
        List<String> result = optimizer
                .optimizeRanges(ZipRangeUtil.getSortedMap(input));
        Assert.assertEquals(result.size(), 3);
    }

    /**
     * Test to check optimizing algorithm when ranges over not overlapping
     */
    @Test
    public void testOptimizeRangesWithoutOverlapping() {
        List<String> input = new ArrayList<>();

        input.add("[20001,25000]");
        input.add("[26000,27673]");
        input.add("[30000,34562]");
        input.add("[45234,65498]");

        RangeOptimizer optimizer = new RangeOptimizer();
        List<String> result = optimizer
                .optimizeRanges(ZipRangeUtil.getSortedMap(input));
        Assert.assertEquals(result.size(), 4);
    }

}
