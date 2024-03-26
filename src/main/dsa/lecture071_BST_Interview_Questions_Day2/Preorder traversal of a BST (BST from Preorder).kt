package lecture071_BST_Interview_Questions_Day2

import Wrapper
import lecture062_Tree_Introduction.BinaryTreeNode

/*
*   https://www.codingninjas.com/studio/problems/preorder-traversal-to-bst_893111
* */
fun main() {

}

private fun preorderToBST(preorder: ArrayList<Int>): BinaryTreeNode<Int>? {
    val mini = Int.MIN_VALUE
    val maxi = Int.MAX_VALUE
    val index = 0

    return solve(preorder, mini, maxi, Wrapper(index))
}

private fun solve(preorder: ArrayList<Int>, mini: Int, maxi: Int,
                  index: Wrapper<Int>): BinaryTreeNode<Int>? {

    // Base case
    if (index.value >= preorder.size) {
        return null
    }
    if (preorder[index.value] < mini || preorder[index.value] > maxi) {
        return null
    }

    val root = BinaryTreeNode(preorder[index.value])
    index.value++
    root.left = solve(preorder, mini, root.data, index)
    root.right = solve(preorder, root.data, maxi, index)

    return root
}
