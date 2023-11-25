package overloading

import kotlin.math.pow

/*
*  Same name different parameters
*    -> Either number of parameters is different
*    -> Or Type is different
* */
fun main(args: Array<String>) {
    println(add(10, 20))
    println(add(15.0, 15.0))
    // Named Arguments
    println(add(num1 = 10, num2 = 20))
    println(add(num2 = 10, num1 = 20))

    // Store function in variable
    var fn: (num1: Double, num2: Double) -> Double = ::add
    println(fn(20.0, 20.0))

    fn = ::power
    println(fn(2.0, 3.0))
}

fun add(num1: Int, num2: Int) = num1 + num2
fun add(num1: Double, num2: Double) = num1 + num2
fun power(num1: Double, num2: Double) = num1.pow(num2)