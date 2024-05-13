package binaryTrees

import printArray

fun main() {
    val root = TreeBuilder.buildTree()

    val ans = ArrayList<Int>()
    leftView(root, 0, ans)
    printArray(ans)
}

private fun leftView(root: TreeNode?, level: Int, ans: ArrayList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    // tracking function call come from same level or not
    if (level == ans.size) {
        ans.add(root.data)
    }

    leftView(root.left, level + 1, ans)

    leftView(root.right, level + 1, ans)
}



