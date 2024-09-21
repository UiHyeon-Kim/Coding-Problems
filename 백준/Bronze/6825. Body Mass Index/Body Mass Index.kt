fun main() {
    val weight = readln().toFloat()
    val height = readln().toFloat()
    val BMI = weight/(height*height)
    when {
        BMI > 25 -> println("Overweight")
        18.5 < BMI && BMI <= 25 -> println("Normal weight")
        18.5 >= BMI -> println("Underweight")
    }
}