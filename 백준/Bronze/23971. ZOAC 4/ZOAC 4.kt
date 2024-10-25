import kotlin.math.ceil

fun main() {
    val (H, W, N, M) = readln().split(" ").map { it.toFloat() }
    val result = ceil(H / (N + 1)).toInt() * ceil(W / (M + 1)).toInt()
    println(result)
}