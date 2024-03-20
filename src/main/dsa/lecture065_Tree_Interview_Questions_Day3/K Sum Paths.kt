package lecture065_Tree_Interview_Questions_Day3

import lecture062_Tree_Introduction.TreeNode


/*
*   https://www.geeksforgeeks.org/problems/k-sum-paths/1
* */
fun main() {

}

private var count = 0

private fun sumK(root: TreeNode?, k: Int): Int {
    solve(root, k, ArrayList())

    return count
}

private fun solve(root: TreeNode?, k: Int, path: MutableList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    path.add(root.data)

    solve(root.left, k, path)

    solve(root.right, k, path)

    val size = path.size
    var sum = 0
    for (i in size - 1 downTo 0) {
        sum += path[i]
        if (sum == k) {
            count++
        }
    }


    // remove added value when back
    path.removeAt(size - 1)
}