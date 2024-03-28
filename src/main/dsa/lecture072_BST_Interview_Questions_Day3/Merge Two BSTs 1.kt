package lecture072_BST_Interview_Questions_Day3

import lecture062_Tree_Introduction.TreeNode

/*
*   https://www.naukri.com/code360/problems/h_920474
* */
fun main() {

}

private fun mergeBST(root1: TreeNode?, root2: TreeNode?): List<Int> {
    val bst1: MutableList<Int> = ArrayList()
    val bst2: MutableList<Int> = ArrayList()

    inorder(root1, bst1)
    inorder(root2, bst2)

    val mergeArray = mergeArray(bst1, bst2)

    val start = 0
    val end = mergeArray.size - 1

    //return inorderToBST(start, end, mergeArray);
    return mergeArray
}

private fun inorderToBST(start: Int, end: Int, inorder: List<Int>): TreeNode? {

    // Base case
    if (start > end) {
        return null
    }

    val mid = start + (end - start) / 2
    val root: TreeNode = TreeNode(inorder[mid])
    root.left = inorderToBST(start, mid - 1, inorder)
    root.right = inorderToBST(mid + 1, end, inorder)

    return root
}

private fun mergeArray(a: List<Int>, b: List<Int>): List<Int> {

    val ans: MutableList<Int> = ArrayList()

    var i = 0
    var j = 0
    var k = 0

    while (i < a.size && j < b.size) {
        if (a[i] < b[j]) {
            ans.add(a[i])
            i++
            k++
        } else {
            ans.add(b[j])
            j++
            k++
        }
    }

    while (i < a.size) {
        ans.add(a[i])
        i++
        k++
    }
    while (j < b.size) {
        ans.add(b[j])
        j++
        k++
    }

    return ans
}

private fun inorder(root: TreeNode?, inorderVal: MutableList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    // L
    inorder(root.left, inorderVal)

    // N
    inorderVal.add(root.data)

    // R
    inorder(root.right, inorderVal)
}



