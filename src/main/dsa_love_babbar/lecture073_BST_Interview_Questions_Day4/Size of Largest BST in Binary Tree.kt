package lecture073_BST_Interview_Questions_Day4

import Wrapper
import lecture062_Tree_Introduction.TreeNode
import kotlin.math.max
import kotlin.math.min

fun main() {
    val root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)

    val ans = largestBST(root)

    println("Largest BST size is: $ans")
}

private fun largestBST(root: TreeNode?): Int {

    val maxSize: Wrapper<Int> = Wrapper(0)

    val temp = solve(root, maxSize)

    return maxSize.value
}

private fun solve(root: TreeNode?, ans: Wrapper<Int>): Info {

    // Base case
    if (root == null) {
        return Info(maxi = Int.MIN_VALUE, mini = Int.MAX_VALUE, isBST = true, size = 0)
    }

    val left = solve(root.left, ans)
    val right = solve(root.right, ans)

    val currNode = Info()

    currNode.size = left.size + right.size + 1
    currNode.maxi = max(root.data, right.maxi)
    currNode.mini = min(root.data, left.mini)

    currNode.isBST = left.isBST && right.isBST && (root.data > left.maxi && root.data < right.mini)

    if (currNode.isBST) {
        ans.value = max(ans.value.toDouble(), currNode.size.toDouble()).toInt()
    }

    return currNode
}

private class Info {
    var maxi: Int = Int.MIN_VALUE
    var mini: Int = Int.MAX_VALUE
    var isBST: Boolean = false
    var size: Int = 0

    constructor()

    constructor(maxi: Int, mini: Int, isBST: Boolean, size: Int) {
        this.maxi = maxi
        this.mini = mini
        this.isBST = isBST
        this.size = size
    }
}

