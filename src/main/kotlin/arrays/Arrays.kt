package arrays

/*
*  - Object that stores multiple values of same type
*  - Fixed size
* */
fun main(args: Array<String>) {
    val arr1 = arrayOf("One", "Two", "Three")
    val arr2 = arrayOf<Int>(1, 2, 3)

    for ((index, value) in arr1.withIndex()) {
        println("$index - $value")
    }

    println(arr1[0])

    arr1[0] = "Hello"
    println(arr1[0])

    println("Size - ${ arr1.size }")

    val sum: Int = arr2.sum()
    println(sum)

    println(arr1[3]) // ArrayIndexOutOfBoundsException (IndexOutOfBoundsException)
}