package ols2405;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MathTest {
    @Test
    public void shouldAddTwoIntegers() {
        assertEquals(30, Math.add(10, 20));
    }
}