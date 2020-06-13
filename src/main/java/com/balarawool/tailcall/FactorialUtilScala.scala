package com.balarawool.tailcall

object FactorialUtilScala {
  def factorial(n: BigInt, acc: BigInt): BigInt =
    if (n == 1) acc
    else factorial(n - 1, n * acc)

  def main(args: Array[String]): Unit = {
    println(factorial(5, 1))
    println(factorial(10, 1))
    println(factorial(50000, 1))
  }
}
