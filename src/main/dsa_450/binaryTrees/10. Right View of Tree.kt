package binaryTrees

import printArray

fun main() {
    val root = TreeBuilder.buildTree()

    val ans = ArrayList<Int>()
    rightView(root, 0, ans)
    printArray(ans)
}

private fun rightView(root: TreeNode?, level: Int, ans: ArrayList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    // tracking function call come from same level or not
    if (level == ans.size) {
        ans.add(root.data)
    }

    rightView(root.right, level + 1, ans)

    rightView(root.left, level + 1, ans)
}



