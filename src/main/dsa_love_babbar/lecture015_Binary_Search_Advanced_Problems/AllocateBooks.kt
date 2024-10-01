package lecture015_Binary_Search_Advanced_Problems

fun main() {
    val times = intArrayOf(2, 2, 3, 3, 4, 4, 1)
    val result = allocateBooksMaxDays(4, 7, times)
    println(result)
}

private fun allocateBooksMaxDays(n: Int, m: Int, time: IntArray): Long {
    val days = n

    var start = 0
    var end = 0

    for (i in time.indices) {
        end += time[i]
    }

    var mid = start + (end - start) / 2

    var ans = -1

    while (start <= end) {
        if (isProceed(days, time, mid)) {
            ans = mid
            end = mid - 1
        } else {
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return ans.toLong()
}

private fun isProceed(days: Int, time: IntArray, mid: Int): Boolean {
    var studyCount = 0
    var dayCount = 1

    for (i in time.indices) {
        if (studyCount + time[i] <= mid) {
            studyCount += time[i]
        } else {
            ++dayCount
            if (dayCount > days || time[i] > mid) {
                return false
            }

            studyCount = time[i]
        }
    }

    return true
}
