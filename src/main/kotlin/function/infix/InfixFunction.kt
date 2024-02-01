package function.infix

fun main() {
    val math = Math()

    val result = math square 3
    println("The square of a number is: $result")

    val chk = Check()
    println(chk dataType 3.3)
}

private class Math {

    infix fun square(n: Int): Int {
        val num = n * n
        return num
    }
}

private class Check {

    infix fun dataType(x: Any): Any {
        return when (x) {
            is String -> "String"
            is Int -> "Integer"
            is Double -> "Double"
            else -> "invalid"
        }
    }
}