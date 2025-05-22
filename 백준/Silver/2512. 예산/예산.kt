fun main() {
    readln()
    val requests = readln().split(" ").map(String::toInt)
    val budget = readln().toInt()

    var min = 0
    var max = requests.max()

    while (min <= max) {
        val mid = (min + max) / 2
        val total = requests.fold(0) { acc: Int, req: Int -> acc + minOf(req, mid) }

        if (total <= budget) {
            min = mid + 1
        } else {
            max = mid - 1
        }
    }

    println(max)
}