package lecture066_Tree_Interview_Questions_Day4

import lecture063_Tree_Interview_Questions_Day1.TreeNode


/*
*   https://www.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
* */
fun main() {

}

private val mapping: MutableMap<Int, Int> = HashMap()

private fun getTreeFromPostorderAndInorder(postOrder: IntArray, inOrder: IntArray): TreeNode<Int>? {

    inorderMapping(inOrder)

    val ans: TreeNode<Int>? = buildTree(inOrder, postOrder,
        IntWrapper(postOrder.size - 1), 0, inOrder.size - 1)

    return ans
}

private fun buildTree(
    inorder: IntArray, postOrder: IntArray, postorderEnd: IntWrapper,
    inorderStart: Int, inorderEnd: Int
): TreeNode<Int>? {

    // Base case
    if (postorderEnd.value < 0 || inorderStart > inorderEnd) {
        return null
    }

    val element = postOrder[postorderEnd.value--]
    val root: TreeNode<Int> = TreeNode(element)
    val position = mapping[element]!!

    root.right = buildTree(inorder, postOrder, postorderEnd, position + 1, inorderEnd)

    root.left = buildTree(inorder, postOrder, postorderEnd, inorderStart, position - 1)

    return root
}

private fun inorderMapping(inorder: IntArray) {
    val size = inorder.size

    for (i in 0..< size) {
        mapping[inorder[i]] = i
    }
}


