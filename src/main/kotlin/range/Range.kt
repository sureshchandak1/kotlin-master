package range

fun main() {
    var number = 10

    var result = number in 1..5 // 1, 2, 3, 4, 5
    println(result)

    result = number in 1 until  5 // 1, 2, 3, 4
    println(result)

    number = 5

    result = number in 1..5 // 1, 2, 3, 4, 5
    println(result)

    result = number in 1 until  5 // 1, 2, 3, 4
    println(result)
}