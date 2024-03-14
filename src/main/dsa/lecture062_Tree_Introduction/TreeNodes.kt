package lecture062_Tree_Introduction

fun main() {

}

class TreeNode {

    var data: Int
    var left: TreeNode?
    var right: TreeNode?

    constructor() {
        this.data = 0
        this.left = null
        this.right = null
    }

    constructor(data: Int) {
        this.data = data
        this.left = null
        this.right = null
    }

    constructor(data: Int, left: TreeNode?, right: TreeNode?) {
        this.data = data
        this.left = left
        this.right = right
    }
}