package languages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class JavaTest {

    @Test
    @DisplayName("simpleTest method works correctly")
    void simpleTest() {
        for (String s : Arrays.asList("1", "2"))
            System.out.println(s);
    }
}