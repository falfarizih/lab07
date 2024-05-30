package postfix;

import java.util.stream.Stream;

public class TestCases {

    /**
     * use this method to incrementally add more test cases
     *
     * @return Stream<Object [ ]>
     * the Object[] contain testcases with the following parameters:
     * like : {"simple plus 2digits", "44+16", "44 16 +", 60,       "44 + 16"},
     * message                 infix   postfix   result     tokenized string
     */
    public static Stream<Object[]> allTestCases() {
        Stream<Object[]> testCases = Stream.of(TestCases.simpleTestCases());
        //testCases = Stream.concat(testCases, Stream.of(TestCases.longerTestCases()));
        //testCases = Stream.concat(testCases, Stream.of(TestCases.exponentialTestCases()));

        // test cases containing multidigit numbers:
        //testCases = Stream.concat(testCases, Stream.of(TestCases.simpleTestCasesMultiDigit()));
        //testCases = Stream.concat(testCases, Stream.of(TestCases.longerTestCasesMultiDigit()));
        //testCases = Stream.concat(testCases, Stream.of(TestCases.multiDigitTestCases()));

        return testCases;
    }

    public static Object[][] simpleTestCases() {
        return new Object[][]{
                {"simple plus", "4+3", "4 3 +", 7, "4 + 3"},
                {"simple minus", "4-3", "4 3 -", 1, "4 - 3"},
                {"simple multiplication", "4*3", "4 3 *", 12, "4 * 3"},
                {"simple division", "7/2", "7 2 /", 3.5, "7 / 2"}};
    }

    public static Object[][] simpleTestCasesMultiDigit() {
        return new Object[][]{
                {"simple plus 2digits", "44+16", "44 16 +", 60, "44 + 16"},
                {"simple plus space", "44 + 16", "44 16 +", 60, "44 + 16"}};
    }

    public static Object[][] longerTestCases() {
        return new Object[][]{
                {"2 plus", "3+4+5", "3 4 + 5 +", 12, "3 + 4 + 5"},
                {"2 minus", "3 - 3 - 3", "3 3 - 3 -", -3},
                {"3 plus", "9 + 9 + 9 + 9", "9 9 + 9 + 9 +", 36},
                {"simple parantheses", "(4 + 3)", "4 3 +", 7, "( 4 + 3 )"},
                {"2 minus with parantheses", "3 - ( 3 - 3 )", "3 3 3 - -", 3},
                {"minus followed by plus", "7 - 8 + 4", "7 8 - 4 +", 3},
                {"paranthesis at beginning", "( 3 + 2 )", "3 2 +", 5},
                {"operator precedence I", "1 * 2 + 3", "1 2 * 3 +", 5},
                {"operator precedence II", "1 + 2 * 3", "1 2 3 * +", 7},
                {"operator precedence III", "9-1-2-3*2-1", "9 1 - 2 - 3 2 * - 1 -", -1, "9 - 1 - 2 - 3 * 2 - 1"},
                {"fractions II II", "1+2+3/4+5+6*(7+8)", "1 2 + 3 4 / + 5 + 6 7 8 + * +", 98.75,
                        "1 + 2 + 3 / 4 + 5 + 6 * ( 7 + 8 )"}};

    }

    public static Object[][] longerTestCasesMultiDigit() {
        return new Object[][]{
                {"simple parantheses multiple digits", "(4 + 33)", "4 33 +", 37, "( 4 + 33 )"}};
    }


    public static Object[][] exponentialTestCases() {
        return new Object[][]{{"exponential I", "4 ^ 2", "4 2 ^", 16},
                {"exponential II", "1 + 2 - 3 ^ 4", "1 2 + 3 4 ^ -", -78},
                {"exponential III", "1 ^ 2 - 3 * 4", "1 2 ^ 3 4 * -", -11},
                {"exponential IV", "1 + 2 * 3 - 4 ^ 5 + 6", "1 2 3 * + 4 5 ^ - 6 +", -1011},
                {"fractions I",
                        "(1 + 2) * 3 + (4^(5 - 6))",
                        "1 2 + 3 * 4 5 6 - ^ +", 9.25,
                        "( 1 + 2 ) * 3 + ( 4 ^ ( 5 - 6 ) )",
                        "1 2 + 3 * 4 5 6 - ^ +"}
        };
    }

    public static Object[][] multiDigitTestCases() {
        return new Object[][]{
                {"multi digit I", "40 * 31", "40 31 *", 1240},
                {"multi digit II", "10 ^ 2", "10 2 ^", 100},
                {"multi digit III", "13 + 21 * 35", "13 21 35 * +", 748, "13 + 21 * 35"}
        };
    }


}
