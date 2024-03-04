fun main() {
    var arr = arrayListOf(0, 1, -2, 3, 4, 0, 5, -27, 9, 0)
    printArray(arr)
    pushZerosAtEnd(arr)
    printArray(arr)
    println("-----------------------------")

    arr = arrayListOf(2, 0, 4, 1, 3, 0, 28)
    printArray(arr)
    pushZerosAtEnd(arr)
    printArray(arr)
    println("-----------------------------")

}

private fun pushZerosAtEnd(arr: ArrayList<Int>) {
    val size = arr.size

    var index = -1

    var temp = -1

    for (i in 0..< size) {
        if (arr[i] != 0) {
            index++

            temp = arr[index]
            arr[index] = arr[i]
            arr[i] = temp
        }
    }
}