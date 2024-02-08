package junit_tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringLengthTest {

    @Test
    public void testStringLength() {
        String text = "This is a long text with more than 15 characters";
        assertTrue(text.length() > 15, "Text length should be greater than 15 characters");
    }
}