package _22

fun main() {
    val s1 = "ab"
    val s2 = "eidbaooo"
    println(checkInclusion(s1, s2))
}

private fun checkInclusion(s1: String, s2: String): Boolean {

    val count1 = IntArray(26) { 0 }
    for (i in s1.indices) {
        val ch = s1[i]
        val number = ch - 'a'
        count1[number]++
    }

    var index = 0
    val windowSize = s1.length
    val count2 = IntArray(26) { 0 }

    while (index < windowSize && index < s2.length) {
        val ch = s2[index]
        val number = ch - 'a'
        count2[number]++

        index++
    }

    if (checkEqual(count1, count2)) return true

    while (index < s2.length) {
        val newCh = s2[index]
        val newNumber = newCh - 'a'
        count2[newNumber]++

        val oldCh = s2[index - windowSize]
        val oldNumber = oldCh - 'a'
        count2[oldNumber]--

        index++

        if (checkEqual(count1, count2)) return true
    }

    return false
}

private fun checkEqual(count1: IntArray, count2: IntArray) : Boolean {
    for (i in 0 .. 25) {
        if (count1[i] != count2[i]) {
            return false
        }
    }

    return true
}