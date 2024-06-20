package binaryTrees

fun main() {
    val root: TreeNode? = TreeBuilder.buildTree()

    mirrorTree(root)
}

private fun mirrorTree(root: TreeNode?): TreeNode? {
    // Base case
    if (root == null) {
        return null
    }

    val left: TreeNode? = mirrorTree(root.left)
    val right: TreeNode? = mirrorTree(root.right)

    root.left = right
    root.right = left

    return root
}





