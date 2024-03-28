import lecture062_Tree_Introduction.TreeNode

/*
*   https://leetcode.com/problems/binary-tree-postorder-traversal/
* */
fun main() {

}

private fun postorderTraversal(root: TreeNode?): List<Int> {
    val ans: MutableList<Int> = ArrayList()
    postorder(root, ans)
    return ans
}

// LRN
private fun postorder(root: TreeNode?, ans: MutableList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    // L - left
    postorder(root.left, ans)

    // R - right
    postorder(root.right, ans)

    // N - node
    ans.add(root.data)
}