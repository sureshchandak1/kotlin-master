package lecture063_Tree_Interview_Questions_Day1

/*
*   https://www.geeksforgeeks.org/problems/sum-tree/1
* */
fun main() {

}

private fun isSumTree(root: TreeNode<Int>?): Boolean {
    return isSumTreeFast(root).isSumTree
}

private fun isSumTreeFast(root: TreeNode<Int>?): TreeSumPair {

    // Base case
    if (root == null) {
        val p = TreeSumPair(true, 0)
        return p
    }
    if (root.left == null && root.right == null) {
        val p = TreeSumPair(true, root.data)
        return p
    }

    val leftAns = isSumTreeFast(root.left)
    val rightAns = isSumTreeFast(root.right)

    val left = leftAns.isSumTree
    val right = rightAns.isSumTree

    val isSumEqual = (root.data == leftAns.sum + rightAns.sum)

    val ans = TreeSumPair(false, 0)

    if (left && right && isSumEqual) {
        ans.isSumTree = true
        ans.sum = root.data + leftAns.sum + rightAns.sum // 2 * root.data
    }

    return ans
}

private class TreeSumPair(isSumTree: Boolean, sum: Int) {
    var isSumTree: Boolean = false
    var sum: Int = 0

    init {
        this.isSumTree = isSumTree
        this.sum = sum
    }
}