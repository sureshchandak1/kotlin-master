import java.util.Stack

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

fun printArray(arr: LongArray) {
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

fun <T> printArray(arr: MutableList<T>) {
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

fun <T> printArray(arr: MutableSet<T>) {
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

fun <T> printArray(arr: MutableCollection<T>) {
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

fun <T> printStack(s: Stack<T>) {
    val stack = s.clone() as Stack<*>
    print("[")
    while (!stack.isEmpty()) {
        print(stack.pop())
        if (!stack.isEmpty()) {
            print(", ")
        }
    }

    print("]")
    println()
}