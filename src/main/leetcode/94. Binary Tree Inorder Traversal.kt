import lecture062_Tree_Introduction.TreeNode

/*
*   https://leetcode.com/problems/binary-tree-inorder-traversal/
* */
fun main() {

}

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val ans: MutableList<Int> = ArrayList()
    inorder(root, ans)
    return ans
}

// LNR
private fun inorder(root: TreeNode?, ans: MutableList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    // L - left
    inorder(root.left, ans)

    // N - node
    ans.add(root.data)

    // R - right
    inorder(root.right, ans)
}

