package ols2405.recursion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactorialTest {
    
    @Test    
    public void testFactorialOf5() {
        assertEquals(120, Factorial.factorial(5));        
    }

    @Test    
    public void testFactorialOf6() {
        assertEquals(720, Factorial.factorial(6));        
    }
}