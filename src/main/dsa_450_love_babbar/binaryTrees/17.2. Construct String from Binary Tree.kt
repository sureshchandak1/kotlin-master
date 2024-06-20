package binaryTrees

/**
 *    https://leetcode.com/problems/construct-string-from-binary-tree/description/
 */
fun main() {
    val root = TreeBuilder.buildTree()

    println("Tree 2 String:")
    val treeString = tree2str(root)
    println(treeString)
}

// depth-first search (DFS)
private fun tree2str(root: TreeNode?): String {
    // Base case: if the current node is null, return an empty string
    if (root == null) {
        return ""
    }

    // Case when both left and right child nodes are null
    if (root.left == null && root.right == null) {
        return root.data.toString()
    }

    // Case when only the right child node is null
    if (root.right == null) {
        return "" + root.data + "(" + tree2str(root.left) + ")"
    }

    // Case when both child nodes are not null
    // Note: The right child node is represented even when it might be null,
    //       because the left child node is not null, and its existence must be acknowledged
    return "" + root.data + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")"
}






