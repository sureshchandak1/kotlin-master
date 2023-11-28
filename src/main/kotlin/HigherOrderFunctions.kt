import kotlin.math.pow

/*
*  - A higher-order function is a function that takes functions as parameters, or returns a function.
* */
fun main() {
    println(sum(2.0, 3.0))
    println(power(2.0, 3.0))

    val sumFn: (a: Double, b: Double) -> Double = ::sum
    println(sumFn(2.0, 4.0))

    calculator(5.0, 5.0, sumFn)
    calculator(5.0, 5.0, ::power)
}

private fun sum(a: Double, b: Double) = a + b

private fun power(a: Double, b: Double) = a.pow(b)

// Higher-Order Function
private fun calculator(a: Double, b: Double, calFun: (Double, Double) -> Double) {
    val result = calFun(a, b)
    println(result)
}


