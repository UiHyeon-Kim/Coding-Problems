fun main() {
    var (H, M) = readln().split(" ").map { it.toInt() }

    if (H == 0 && M < 45) {
        H = 23
        M += 60 - 45
    } else if (M < 45) {
        H -= 1
        M += 60 - 45
    } else {
        M -= 45
    }

    print("$H $M")
}