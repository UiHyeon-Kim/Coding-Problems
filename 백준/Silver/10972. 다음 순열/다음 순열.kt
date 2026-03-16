import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val target = IntArray(n) { st.nextToken().toInt() }

    val pivot = ((n - 1) downTo 1).find { target[it] > target[it - 1] } ?: return@with println(-1)
    val swapTarget = ((n - 1) downTo pivot).find { target[it] > target[pivot - 1] }!!

    target[pivot - 1] = target[swapTarget].also { target[swapTarget] = target[pivot - 1] }
    target.reverse(pivot, n)

    println(target.joinToString(" "))
}