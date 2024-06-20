package lecture075_Heap_Interview_Questions_Day1

import lecture062_Tree_Introduction.TreeNode

/*
*   https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1
* */
fun main() {

}

private fun isHeap(tree: TreeNode): Boolean {
    val index = 0
    val totalCount = countNodes(tree)

    return isCBT(tree, index, totalCount) && isMaxOrder(tree)
}

private fun isCBT(root: TreeNode?, index: Int, cnt: Int): Boolean {

    // Base case
    if (root == null) {
        return true
    }

    if (index >= cnt) {
        return false
    } else {
        val left = isCBT(root.left, 2 * index + 1, cnt)
        val right = isCBT(root.right, 2 * index + 2, cnt)

        return left && right
    }
}

private fun isMaxOrder(root: TreeNode?): Boolean {

    // Base case - leaf node
    if (root != null && root.left == null && root.right == null) {
        return true
    }

    if (root!!.right == null) {
        return (root.data > root.left!!.data)
    } else {
        val left = isMaxOrder(root.left)
        val right = isMaxOrder(root.right)

        return (left && right &&
                (root.data > root.left!!.data && root.data > root.right!!.data))
    }
}

private fun countNodes(root: TreeNode?): Int {

    // Base case
    if (root == null) {
        return 0
    }

    val ans = 1 + countNodes(root.left) + countNodes(root.right)

    return ans
}




