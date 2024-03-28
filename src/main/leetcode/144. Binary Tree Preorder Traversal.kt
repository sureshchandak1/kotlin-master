import lecture062_Tree_Introduction.TreeNode

/*
*   https://leetcode.com/problems/binary-tree-preorder-traversal/
* */
fun main() {

}

private fun preorderTraversal(root: TreeNode?): List<Int> {
    val ans: MutableList<Int> = ArrayList()
    preorder(root, ans)
    return ans
}

// NLR
private fun preorder(root: TreeNode?, ans: MutableList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    // N - node
    ans.add(root.data)

    // L - left
    preorder(root.left, ans)

    // R - right
    preorder(root.right, ans)
}

// work with kotlin nested functions
private fun preorderTraversal2(root: TreeNode?): List<Int> {
    val ans: MutableList<Int> = ArrayList()

    // NLR
    fun preorder(root: TreeNode?) {

        // Base case
        if (root == null) {
            return
        }

        // N - node
        ans.add(root.data)

        // L - left
        preorder(root.left)

        // R - right
        preorder(root.right)
    }

    preorder(root)
    return ans
}