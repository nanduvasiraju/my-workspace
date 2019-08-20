### CodingTests
WilliamSonoma

## Problem Description 

# BACKGROUND
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

# PROBLEM
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

# NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

# EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

Evaluation Guidelines:
Your work will be evaluated against the following criteria:
- Successful implementation
- Efficiency of the implementation
- Design choices and overall code organization
- Code quality and best practices

## SOLUTION

The steps associated with this solution are as follows.
1. Accept a collection of zip code ranges.
2. Validate them for - input, format - correctness.
3. Display errors if any.
4. Optimize and print the final ranges.

## INSTRUCTIONS
1. Download and install Java (JDK 1.8) on the test machine.
2. Download the project (and unzip) and import it as an existing project into eclipse.
3. Modify ZipRangeUtil.java with needed values(It comes with default values).
4. Run the ZipOptimizerClient.java

# TESTS
1. There are a couple of tests in the test folder.
  a. validity of the input.
  b. format of the input.
  
 # ASSUMPTIONS
 1. Same values in the lower and upper for a range are treated as valid.
 2. Zip code like - 000999 - are considered valid. 
