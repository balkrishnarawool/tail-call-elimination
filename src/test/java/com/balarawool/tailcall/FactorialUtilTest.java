package com.balarawool.tailcall;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static com.balarawool.tailcall.FactorialUtil.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialUtilTest {

    @Test
    public void testFactorial() {
        assertEquals(BigInteger.valueOf(120), factorial(BigInteger.valueOf(5)));
        assertEquals(BigInteger.valueOf(3628800), factorial(BigInteger.valueOf(10)));
    }
}
