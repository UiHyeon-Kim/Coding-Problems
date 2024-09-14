import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val score = IntArray(N) { br.readLine().toInt() }
    score.sort()
    br.close()
    score.forEach { bw.write("$it\n") }
    bw.flush()
    bw.close()
}