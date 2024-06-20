package lecture066_Tree_Interview_Questions_Day4

import lecture062_Tree_Introduction.TreeNode


/*
*   https://www.geeksforgeeks.org/problems/construct-tree-1/1
* */
fun main() {

}

private val mapping: MutableMap<Int, Int> = HashMap()

private fun buildBinaryTree(inorder: IntArray, preorder: IntArray): TreeNode? {
    inorderMapping(inorder)

    val ans: TreeNode? = buildTree(inorder, preorder,
        IntWrapper(0), 0, inorder.size - 1)

    return ans
}

private fun buildTree(
    inorder: IntArray, preorder: IntArray, preorderIndex: IntWrapper,
    inorderStart: Int, inorderEnd: Int
): TreeNode? {

    // Base case
    if (preorderIndex.value >= preorder.size || inorderStart > inorderEnd) {
        return null
    }

    val element = preorder[preorderIndex.value++]
    val root: TreeNode = TreeNode(element)
    val position = mapping[element]!!

    root.left = buildTree(inorder, preorder, preorderIndex, inorderStart, position - 1)

    root.right = buildTree(inorder, preorder, preorderIndex, position + 1, inorderEnd)

    return root
}

private fun inorderMapping(inorder: IntArray) {
    val size = inorder.size

    for (i in 0..< size) {
        mapping[inorder[i]] = i
    }
}

class IntWrapper(value: Int) {
    var value: Int = 0

    init {
        this.value = value
    }
}
