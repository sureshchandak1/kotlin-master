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

    val arr = IntArray(5) { -1 }  // construct with size and fill array with 0
    println("${arr[0]}  ${arr[1]}  ${arr[2]}  ${arr[3]}  ${arr[4]}")

    println(arr1[3]) // ArrayIndexOutOfBoundsException (IndexOutOfBoundsException)

}