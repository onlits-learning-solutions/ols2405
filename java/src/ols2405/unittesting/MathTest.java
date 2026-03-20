package ols2405.unittesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTest {
    
    @Test
    public void testAdd() {
        int result = Math.add(10, 20);
        assertEquals(30, result);

        assertEquals(-30, new Math().add(-10, -20));
    }

    @Test
    public void testFactorial() {
        int result = Math.factorial(5);
        assertEquals(120, result);
        
        assertEquals(-1, Math.factorial(-5));
        assertEquals(1, Math.factorial(0));
    }
}