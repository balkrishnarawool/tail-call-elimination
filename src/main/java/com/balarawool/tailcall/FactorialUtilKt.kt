package com.balarawool.tailcall

import java.math.BigInteger

tailrec fun factorial(n: BigInteger, acc: BigInteger): BigInteger {
    return  if (n == BigInteger.ONE) acc
            else factorial(n - BigInteger.ONE, n * acc)
}

fun main() {
    println(factorial(BigInteger.valueOf(5), BigInteger.ONE))
    println(factorial(BigInteger.valueOf(10), BigInteger.ONE))
    println(factorial(BigInteger.valueOf(50000), BigInteger.ONE))
}

