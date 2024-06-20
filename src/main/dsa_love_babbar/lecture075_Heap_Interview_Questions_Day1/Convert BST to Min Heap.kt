package lecture075_Heap_Interview_Questions_Day1

import lecture062_Tree_Introduction.TreeNode

/*
*   https://www.naukri.com/code360/problems/convert-bst-to-min-heap_920498
* */
fun main() {

}

private fun convertBST(root: TreeNode?): TreeNode? {
    val inorder: MutableList<Int> = ArrayList()

    inorder(root, inorder)

    index = 0
    fillPreorder(root, inorder)

    return root
}

// L N R
private fun inorder(root: TreeNode?, ans: MutableList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    inorder(root.left, ans) // L

    ans.add(root.data) // N

    inorder(root.right, ans) // R
}

private var index = 0

// N L R - for min heap
private fun fillPreorder(root: TreeNode?, inorder: List<Int>) {

    // Base case
    if (root == null) {
        return
    }

    root.data = inorder[index++] // N

    fillPreorder(root.left, inorder) // L

    fillPreorder(root.right, inorder) // R
}


