fun main() {
    while (true) {
        val (one, two, three) = readln().split(" ").map { it.toInt() }
        if (one == 0 && two == 0 && three == 0) break
        else if (one + two <= three || one + three <= two || two + three <= one) println("Invalid")
        else if (one == two && one == three) println("Equilateral")
        else if (one == two || one == three || two == three) println("Isosceles")
        else println("Scalene")
    }
}