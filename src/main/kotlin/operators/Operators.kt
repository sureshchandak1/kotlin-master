package operators

fun main(args: Array<String>) {
    var i = 13
    val j = 2

    // Arithmetic Operators
    println(i + j) // 15
    println(i - j) // 11
    println(i * j) // 26
    println(i.toFloat() / j) // 6.5
    println(i % j) // 1

    // Relational Operators
    println()
    println(i > j)
    println(i < j)
    println(i >= j)
    println(i <= j)
    println(i == j)
    println(i != j)

    // Pre/Post increment decrement
    println()
    println(i++)
    println(i)
    println()
    println(--i)
    println(i)

    ++i // Pre increment
    i++ // Post increment

    --i // Pre decrement
    i-- // Post decrement

    var k = 10
    println()
    println(k++ + ++k) // 10 + 12 = 22
}