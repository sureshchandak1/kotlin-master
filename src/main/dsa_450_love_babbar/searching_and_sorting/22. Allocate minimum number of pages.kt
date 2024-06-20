package searching_and_sorting

/**
 *    https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
 *    Time Complexity: O(N log(N))
 *    Space Complexity: O(1)
 */
fun main() {
    var pages = intArrayOf(12, 34, 67, 90)
    println(findPages(pages, pages.size, 2))
    pages = intArrayOf(15, 17, 20)
    println(findPages(pages, pages.size, 2))
    pages = intArrayOf(25, 46, 28, 49, 24)
    println(findPages(pages, pages.size, 4))
}

/**
 *    @param pages = arr[i] number of pages
 *    @param n = total n books
 *    @param m = number of students
 */
private fun findPages(pages: IntArray, n: Int, m: Int): Int {

    if (m > n) {
        return -1
    }

    // find search space
    var sum = 0
    for (value in pages) {
        sum += value
    }


    // binary search
    var start = 0
    var end = sum
    var mid = start + (end - start) / 2

    var ans = -1

    while (start <= end) {
        if (isPossible(pages, n, m, mid)) {
            ans = mid
            end = mid - 1
        } else {
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return ans
}

private fun isPossible(arr: IntArray, n: Int, m: Int, mid: Int): Boolean {
    var studentCount = 1
    var pageSum = 0

    for (value in arr) {
        if (pageSum + value <= mid) {
            pageSum += value
        } else {
            studentCount++
            if (studentCount > m || value > mid) {
                return false
            }
            pageSum = value
        }
    }

    return true
}







