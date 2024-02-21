fun main() {

}

private fun getInversions(arr: LongArray, n: Int): Long {
    return count(arr, 0, n - 1)
}

private fun count(arr: LongArray, start: Int, end: Int): Long {
    if (start >= end) {
        return 0
    }

    val mid = start + (end - start) / 2

    // left part
    var inv = count(arr, start, mid)

    // right part
    inv += count(arr, mid + 1, end)

    // merge
    inv += merge(arr, start, end)

    return inv
}

private fun merge(arr: LongArray, start: Int, end: Int): Long {
    var ans: Long = 0

    val mid = start + (end - start) / 2

    val len1 = mid - start + 1
    val len2 = end - mid

    val first = LongArray(len1)
    val second = LongArray(len2)

    // Copy value
    var mainArrayIndex = start
    for (i in 0..<len1) {
        first[i] = arr[mainArrayIndex++]
    }

    mainArrayIndex = mid + 1
    for (i in 0..<len2) {
        second[i] = arr[mainArrayIndex++]
    }

    // merge 2 sorted arrays
    var index1 = 0
    var index2 = 0
    mainArrayIndex = start

    while (index1 < len1 && index2 < len2) {
        if (first[index1] < second[index2]) {
            arr[mainArrayIndex++] = first[index1++]
        } else {
            ans += (len1 - index1).toLong()

            arr[mainArrayIndex++] = second[index2++]
        }
    }

    while (index1 < len1) {
        arr[mainArrayIndex++] = first[index1++]
    }

    while (index2 < len2) {
        arr[mainArrayIndex++] = second[index2++]
    }

    return ans
}