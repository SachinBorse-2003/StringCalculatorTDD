import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringCalculatorTest {

    @Test
    void testStringCalculatorInstance(){
        StringCalculator stringCalculator = new StringCalculator();
        assertNotNull(stringCalculator);
    }

    @Test
    void testEmptyString(){
        assertEquals("0",StringCalculator.add(""),"Empty String should return 0");
    }
    //Should we test alphabets in strings
    @Test
    void testSingleNumberAsInput(){
        assertEquals("1",StringCalculator.add("1"));
    }
    @Test
    void testTwoNumbers(){
        assertEquals("3",StringCalculator.add("1,2"));

    }
    @Test
    void testMultipleNumbersAndDifferentDelimiters(){
        assertEquals("6",StringCalculator.add("1,2,3"));
        assertEquals("10",StringCalculator.add("1\n2,3,4"));
    }

    @Test
    void testMissingNumberInLastPosition(){
        assertEquals("Number expected but EOF found.",StringCalculator.add("1,"));
    }
    @Test
    void testNewLineAsInvalidSeparator(){
        assertEquals("Number expected but '\\n' found at position 1",StringCalculator.add("1,\n2,3,4"));
        assertEquals("Number expected but '\\n' found at position 1",StringCalculator.add("1\n,2,3,4"));

    }
    @Test
    void testNegativeNumbersAreNotAllowed(){
        assertEquals("Negative not allowed : -1",StringCalculator.add("-1,2"));
    }

}
