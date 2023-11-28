fun main() {
    val sumFn: (Int, Int) -> Int = ::sum
    val lambda1: () -> Unit = {  }
    val lambda2: (Int, Int) -> Int = { x: Int, y: Int -> x + y}
    val lambda3: () -> Int = {
        println("Hello Lambda")
        100 + 1 // return type is last line Int, String ...
    }

    println(lambda1())
    println(lambda2(2, 4))
    println(lambda3())

    val lambda4: (Int) -> Int = { x -> x * x }
    val lambda5: (Int) -> Int = { it * it }
    println(lambda4(4))
    println(lambda5(4))

    val print: (String) -> Unit = { message: String -> println(message) }
    print("Hello Lambda")

    calculator(1, 2, {a, b -> a + b })
    calculator(1, 2) { a, b -> a + b }
}

private fun sum(a: Int, b: Int) = a + b

private fun calculator(a: Int, b: Int, calFun: (Int, Int) -> Int) : Int = calFun(a, b)



