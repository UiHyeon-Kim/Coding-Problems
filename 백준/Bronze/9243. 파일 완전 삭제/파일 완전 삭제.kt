fun main() {
    val n = readln().toInt()
    var before = readln()
    val after = readln()
    var isTrue = true

    if (n % 2 == 0) {
        if (before == after) println("Deletion succeeded") else println("Deletion failed")
    } else {
        for (i in before.indices) {
            if (before[i] == after[i]) {
                isTrue = false
                break
            }
        }
        if (isTrue == false) println("Deletion failed") else println("Deletion succeeded")
    }
}
