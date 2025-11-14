data class Edge(val start: Int, val end: Int, val weight: Int)

class UnionFind(size: Int) {
    private val parent = IntArray(size + 1) { it }
    private val rank = IntArray(size + 1) { 0 }

    private fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX == rootY) return false

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY
        }
        else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX
        }
        else {
            parent[rootY] = rootX
            rank[rootX]++
        }

        return true
    }
}

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    val edges = mutableListOf<Edge>()

    repeat(e) {
        val (start, end, weight) = readln().split(" ").map { it.toInt() }
        edges.add(Edge(start, end, weight))
    }

    edges.sortBy { it.weight }
    
    val uf = UnionFind(v + 1)
    var total = 0
    var count = 0

    for (edge in edges) {
        if (uf.union(edge.start, edge.end)) {
            total += edge.weight
            count++

            if (count == v - 1) break
        }
    }

    println(total)
}