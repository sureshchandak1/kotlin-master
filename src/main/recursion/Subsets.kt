// Print all the subsets of a set of first n natural numbers

fun main() {
    findSubsets(3, ArrayList())
}

private fun findSubsets(n: Int, subset: MutableList<Int>) {

    if (n == 0) {
        printSubset(subset)
        return
    }

    // add
    subset.add(n)
    findSubsets(n - 1, subset)

    // not add
    subset.remove((subset.size - 1))
    findSubsets(n - 1, subset)
}

private fun printSubset(subset: List<Int>) {
    subset.forEach {
        print("$it ")
    }
    println()
}