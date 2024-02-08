package easy

fun main() {
    val arr = intArrayOf(0,1,0,3,12)
    printArray(arr)
    moveZeroes(arr)
    printArray(arr)
}

private fun moveZeroes(nums: IntArray): Unit {

    var index = -1

    for (i in nums.indices) {
        if (nums[i] != 0) {
            index++

            val temp = nums[index]
            nums[index] = nums[i]
            nums[i] = temp
        }
    }

}

fun printArray(arr: IntArray) {
    print("[")
    val size = arr.size
    for ((index, item) in arr.withIndex()) {
        print("$item")
        if (index < size - 1) {
            print(", ")
        }
    }
    print("]")
    println()
}

fun printArray(arr: MutableList<Int>) {
    print("[")
    val size = arr.size
    for ((index, item) in arr.withIndex()) {
        print("$item")
        if (index < size - 1) {
            print(", ")
        }
    }
    print("]")
    println()
}