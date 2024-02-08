package junit_tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringLengthTest {

    @ParameterizedTest
    @ValueSource(strings = {"Short", "Exactly 15 chars", "Longer than 15 characters"})
    public void testStringLength(String text) {
        assertTrue(text.length() > 15, "Text length should be greater than 15 characters");
    }
}