package lecture097_Kruskals_Algorithm

fun main(args: Array<String>) {
    // Let there be 5 persons with ids as 0, 1, 2, 3 and 4
    val n = 5
    val dus = DisjointUnionSets(n)

    dus.unionSet(0, 2) // 0 is a friend of 2
    dus.unionSet(4, 2) // 4 is a friend of 2
    dus.unionSet(3, 1) // 3 is a friend of 1

    // Check if 4 is a friend of 0
    if (dus.findParent(4) == dus.findParent(0)) println("Yes") else println("No")

    // Check if 1 is a friend of 0
    if (dus.findParent(1) == dus.findParent(0)) println("Yes") else println("No")
}

// Time complexity: O(n) and Space complexity: O(n)
private class DisjointUnionSets(private val n: Int) {

    private val parent = IntArray(n)
    private val rank = IntArray(n) { 0 }

    init {
        makeSet()
    }

    private fun makeSet() {
        for (i in 0 ..< n) {
            parent[i] = i // Initially, all elements are in their own set(parent)
        }
    }

    fun findParent(node: Int): Int {

        // if x is not the parent of itself
        if (parent[node] != node) {
            // recursively call Find on its parent
            parent[node] = findParent(parent[node])
        }

        return parent[node]
    }

    fun unionSet(u: Int, v: Int) {
        // find parent
        val uParent = findParent(u)
        val vParent = findParent(v)

        // elements are in the same set, no need to unite anything
        if (uParent == vParent) {
            return
        }

        // find rank
        val uRank = rank[uParent]
        val vRank = rank[vParent]

        if (uRank < vRank) {
            parent[uParent] = vParent
        } else if (vRank < uRank) {
            parent[vParent] = uParent
        } else {
            parent[vParent] = uParent // then move v under u (doesn't matter which one goes where)
            rank[uParent]++ // increment the result tree's rank by 1
        }
    }
}





