package bit_manipulation.basics

fun main() {
    var arr = intArrayOf(1, 2, 3, 2, 5, 6, 7, 8, 9)
    findDuplicateMissing(arr)

    arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 10)
    findDuplicateMissing(arr)
}

private fun findDuplicateMissing(arr: IntArray) {

    var ans = 0
    for (value in arr) {
        ans = ans xor value
    }

    for (i in 1 .. arr.size) {
        ans = ans xor i
    }

    val mask = -ans // 2's complement
    val rsbMask = ans and mask // right most set bit mask

    var ans1 = 0
    var ans2 = 0

    for (value in arr) {
        if ((value and rsbMask) == 0) {
            ans1 = ans1 xor value
        } else {
            ans2 = ans2 xor value
        }
    }

    for (i in 1 .. arr.size) {
        if ((i and rsbMask) == 0) {
            ans1 = ans1 xor i
        } else {
            ans2 = ans2 xor i
        }
    }

    for (value in arr) {
        if (value == ans1) {
            println("Missing Number = $ans2")
            println("Repeating Number = $ans1")
            break
        } else if (value == ans2) {
            println("Missing Number = $ans1")
            println("Repeating Number = $ans2")
            break
        }
    }
}













