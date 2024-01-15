package loops

fun main() {
    val number = 2
    var index = 1
    while (index <= 10) {
        println(number * index)
        ++index
    }
    println("Index = $index")

    sumOfEven(5)
}

private fun sumOfEven(n: Int) {

    var sum = 0
    var index = 2

    while (index <= n) {
        sum += index

        index += 2
    }

    println("Even number sum = $sum")
}