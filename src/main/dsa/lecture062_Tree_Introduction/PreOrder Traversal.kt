package lecture062_Tree_Introduction

/*
*      N L R
* */
fun main() {
    var root: TreeNode? = null

    root = buildTree()

    println("PreOrder Traversal")
    preOrder(root)
}

private fun buildTree(): TreeNode? {

    println("Enter the data: ")
    val data: Int = readln().toInt()

    val root = TreeNode(data)

    if (data == -1) {
        return null
    }

    println("Enter data for inserting in left of $data ")
    root.left = buildTree()

    println("Enter data for inserting in right of $data ")
    root.right = buildTree()

    return root

}

private fun preOrder(root: TreeNode?) {
    // N L R

    if (root == null) {
        return
    }

    print("${root.data} ") // N

    preOrder(root.left) // L

    preOrder(root.right) // R
}