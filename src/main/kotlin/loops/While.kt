package loops

fun main() {
    val number = 2
    var index = 1
    while (index <= 10) {
        println(number * index)
        ++index
    }
    println("Index = " + index)
}