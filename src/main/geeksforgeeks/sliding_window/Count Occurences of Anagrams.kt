package sliding_window

/*
*   https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
* */
fun main() {
    println(search("for", "forxxorfxdofr"))
    println(search("aaba", "aabaabaa"))
}

private fun search(pat: String, txt: String): Int {

    val countMap: MutableMap<Char, Int> = HashMap()

    for (element in pat) {
        countMap.merge(element, 1) { a: Int?, b: Int? ->
            Integer.sum(a!!, b!!)
        }
    }

    val k = pat.length // window size
    val size = txt.length

    var count = countMap.size
    var i = 0 // start
    var j = 0 // end

    var ans = 0

    while (j < size) {

        if (countMap.containsKey(txt[j])) {
            val value = countMap[txt[j]]!!
            countMap[txt[j]] = value - 1

            if (countMap[txt[j]] == 0) {
                count--
            }
        }

        if (j - i + 1 < k) {
            j++
        } else if (j - i + 1 == k) {
            if (count == 0) {
                ans++
            }

            if (countMap.containsKey(txt[i])) {
                val value = countMap[txt[i]]!!
                countMap[txt[i]] = value + 1

                if (countMap[txt[i]] == 1) {
                    count++
                }
            }

            i++
            j++
        }
    }

    return ans
}


