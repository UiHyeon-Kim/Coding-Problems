data class TreeNode(
    val node: String,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun buildTree(inputs: List<Triple<String, String, String>>): TreeNode? {
    val nodes = mutableMapOf<String, TreeNode>()

    for ((parent, left, right) in inputs) {
        val parentNode = nodes.getOrPut(parent) { TreeNode(parent) }
        if (left != ".") parentNode.left = nodes.getOrPut(left) { TreeNode(left) }
        if (right != ".") parentNode.right = nodes.getOrPut(right) { TreeNode(right) }
    }

    return nodes[inputs.first().first]
}

fun preorder(node: TreeNode?) {
    if (node == null) return
    print(node.node)
    preorder(node.left)
    preorder(node.right)
}

fun inorder(node: TreeNode?) {
    if (node == null) return
    inorder(node.left)
    print(node.node)
    inorder(node.right)
}

fun postorder(node: TreeNode?) {
    if (node == null) return
    postorder(node.left)
    postorder(node.right)
    print(node.node)
}

fun main() {
    val n = readln().toInt()
    val inputs = mutableListOf<Triple<String, String, String>>()

    repeat(n) {
        val (parent, left, right) = readln().split(" ")
        inputs.add(Triple(parent, left, right))
    }

    val root = buildTree(inputs)

    preorder(root)
    println()
    inorder(root)
    println()
    postorder(root)
}
