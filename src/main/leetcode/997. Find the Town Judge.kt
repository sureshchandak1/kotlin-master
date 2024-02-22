fun main() {

}

private fun findJudge(n: Int, trust: Array<IntArray>): Int {

    // Array to keep track of the number of people each person trusts
    val trustCount = IntArray(n + 1)

    // Array to keep track of the number of people who trust each person
    val trustedByCount = IntArray(n + 1)

    for (relation in trust) {
        val personTrusts = relation[0]
        val personTrusted = relation[1]

        trustCount[personTrusts]++
        trustedByCount[personTrusted]++
    }

    for (i in 1..n) {
        if (trustCount[i] == 0 && trustedByCount[i] == n - 1) {
            return i
        }
    }

    return -1
}