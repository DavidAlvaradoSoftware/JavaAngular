import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class StringUtilTest {

    @Test
    void reverse() {
        String testString = "abcd";
        String result = StringUtil.reverse(testString);
        Assertions.assertEquals("dcba", result);
    }

    @Test
    void invalidInput_reverse() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                                                    () -> {StringUtil.reverse(null)
                                                    ;});

    }

    @Test
    void isPalindrome() {
        String testString = "radar";
        Boolean result = StringUtil.isPalindrome(testString);
        Assertions.assertTrue(result);
    }

    @Test
    void invalidInput_isPalindrome() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {StringUtil.isPalindrome(null)
                ;});

    }

}