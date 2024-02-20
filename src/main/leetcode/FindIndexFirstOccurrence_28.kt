fun main() {
    println(strStr("mississippi", "issip"))
}

private fun strStr(haystack: String, needle: String): Int {

    val haySize = haystack.length
    val needleSize = needle.length

    var hayTracker = 0
    var needleTracker = 0

    while (hayTracker < haySize) {

        if (haystack[hayTracker] == needle[needleTracker]) {

            if (needleSize == 1) {
                return hayTracker
            }

            hayTracker++
            needleTracker++
        } else {
            hayTracker -= needleTracker - 1
            needleTracker = 0
        }

        if (needleTracker == needleSize) {
            return hayTracker - needleTracker
        }

    }

    return -1

}