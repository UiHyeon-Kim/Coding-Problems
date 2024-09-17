fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().chunked(1).sortedDescending().joinToString("")
    br.close()

    bw.write(n)

    bw.flush()
    bw.close()
}