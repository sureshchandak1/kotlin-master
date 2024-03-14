package lecture062_Tree_Introduction

/*
*      L R N
* */
fun main() {
    var root: TreeNode? = null

    root = buildTree()

    println("PostOrder Traversal")
    postOrder(root)
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

private fun postOrder(root: TreeNode?) {
    // L R N

    if (root == null) {
        return
    }

    postOrder(root.left) // L

    postOrder(root.right) // R

    print("${root.data} ") // N
}