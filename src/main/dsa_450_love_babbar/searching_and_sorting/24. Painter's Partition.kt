package searching_and_sorting

fun main() {
    var arr = mutableListOf(2, 1, 5, 6, 2, 3)
    println(findLargestMinDistance(arr, 2))
    arr = mutableListOf(10, 5, 20, 25, 17, 23, 2, 9, 4, 13)
    println(findLargestMinDistance(arr, 7))
}

private fun findLargestMinDistance(boards: MutableList<Int>, k: Int): Int {
    var start = 0
    var end = 0

    for (i in boards.indices) {
        end += boards[i]
    }

    var mid = start + (end - start) / 2

    var ans = -1

    while (start <= end) {
        if (isProceed(boards, k, mid)) {
            ans = mid
            end = mid - 1
        } else {
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return ans
}

private fun isProceed(boards: MutableList<Int>, k: Int, mid: Int): Boolean {
    var paintTimeSum = 0
    var painterCount = 1

    for (index in boards.indices) {
        if (paintTimeSum + boards[index] <= mid) {
            paintTimeSum += boards[index]
        } else {
            ++painterCount
            if (painterCount > k || boards[index] > mid) {
                return false
            }

            paintTimeSum = boards[index]
        }
    }

    return true
}







