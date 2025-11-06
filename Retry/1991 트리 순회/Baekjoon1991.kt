data class Node(
    var alphabet: String,
    var left: Node? = null,
    var right: Node? = null
)

class Baekjoon1991 {

    private lateinit var tree: MutableMap<String, Node>

    fun solve() {
        val n = readln().toInt()
        tree = mutableMapOf()

        repeat(n) {
            val (p, l, r) = readln().split(" ")

            val parent = getNode(p)
            if (l != ".") parent.left = getNode(l)
            if (r != ".") parent.right = getNode(r)
        }

        val root = tree["A"]

        preorder(root)
        println()
        inorder(root)
        println()
        postorder(root)
    }

    private fun getNode(parent: String): Node = tree.getOrPut(parent) { Node(parent) }

    private fun preorder(node: Node?) {
        if (node == null) return
        print(node.alphabet)
        preorder(node.left)
        preorder(node.right)
    }

    private fun inorder(node: Node?) {
        if (node == null) return
        inorder(node.left)
        print(node.alphabet)
        inorder(node.right)
    }

    private fun postorder(node: Node?) {
        if (node == null) return
        postorder(node.left)
        postorder(node.right)
        print(node.alphabet)
    }
}

fun main() {
    Baekjoon1991().solve()
}
