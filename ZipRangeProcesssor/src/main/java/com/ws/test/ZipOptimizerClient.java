package com.ws.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.ws.test.model.Range;
import com.ws.test.optimizer.RangeOptimizer;
import com.ws.test.utils.ZipRangeUtil;
import com.ws.test.validation.RangeValidator;

/**
 * <code>ZipOptimizerClient</code> optimizes a given input of 5-digit ZIP
 * code range sets into minimum number of range sets, keeping the original input
 * constraints intact.
 * <br>The input range is provided as command line argument and
 * the class performs validations on the input, and prints the final result on
 * the console
 *
 * @author RVASIRAJ
 * @version 1.0
 */
public class ZipOptimizerClient {

    

    public static void main(String[] args) {
      BasicConfigurator.configure();
      
      final  Logger log = Logger.getLogger(ZipOptimizerClient.class);
      
        // get the input from Util class
        List<String> inputRange = ZipRangeUtil.getInputRange();
        System.out.println(
                "-------------------------Input Ranges List-------------------------");
        for (String range : inputRange)
            System.out.print(range);
        System.out.println("");

        try {
            // Validate input ranges
            RangeValidator validator = new RangeValidator();
            validator.isValid(inputRange);

            // Sort the ranges based on the starting value
            Map<Integer, Range> sortedMap = ZipRangeUtil
                    .getSortedMap(inputRange);

            // optimize the ranges and print the result
            RangeOptimizer optimizer = new RangeOptimizer();
            List<String> optimizedList = optimizer.optimizeRanges(sortedMap);

            System.out.println(
                    "-------------------------Optimized Ranges List-------------------------");
            for (String range : optimizedList)
                System.out.print(range);

        }

        catch (IllegalArgumentException ex) {
            System.out.println(
                    "Input not processed.Please check log file for details");
            log.error(ex.getMessage());
        }

    }

}
