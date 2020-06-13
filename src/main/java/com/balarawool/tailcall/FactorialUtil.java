package com.balarawool.tailcall;

import java.math.BigInteger;

import static com.balarawool.tailcall.TailCall.ret;
import static com.balarawool.tailcall.TailCall.sus;

public class FactorialUtil {

    public static BigInteger factorial(BigInteger n) {
        return n.equals(BigInteger.ONE)
                ? BigInteger.ONE
                : n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    public static BigInteger factorial(BigInteger n, BigInteger acc) {
        return n.equals(BigInteger.ONE)
                ? acc
                : factorial(n.subtract(BigInteger.ONE), n.multiply(acc));
    }

    public static BigInteger factorialStackSafe(BigInteger n) {
        return factorial_(n, BigInteger.ONE).eval();
    }
    private static TailCall<BigInteger> factorial_(BigInteger n, BigInteger acc) {
        return n.equals(BigInteger.ONE)
                ? ret(acc)
                : sus(() -> factorial_(n.subtract(BigInteger.ONE), n.multiply(acc)));
    }

    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(5)));
        System.out.println(factorial(BigInteger.valueOf(10)));
        System.out.println(factorial(BigInteger.valueOf(5), BigInteger.ONE));
        System.out.println(factorial(BigInteger.valueOf(10), BigInteger.ONE));

        System.out.println(factorialStackSafe(BigInteger.valueOf(5)));
        System.out.println(factorialStackSafe(BigInteger.valueOf(10)));
        System.out.println(factorialStackSafe(BigInteger.valueOf(50_000)));
    }
}
