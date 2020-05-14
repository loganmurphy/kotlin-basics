package example.myapp.enum

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0X00FF00), BLUE(0X000FF)
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun main() {
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)
}