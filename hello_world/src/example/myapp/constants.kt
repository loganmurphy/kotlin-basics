package example.myapp

/* const keyword makes the value determined at compile time rather than run time */
const val CONSTANT1 = "a constant"

/* singleton class holding constants */
object Constants {
    const val CONSTANT2 = "another constant"
}

class ClassWithConstants {
    companion object CompanionConstants {
        const val CONSTANT3 = "constant in a companion object"
    }

    fun printConstants() = println(CompanionConstants.CONSTANT3)
}

fun main() {
    println(CONSTANT1)
    println(Constants.CONSTANT2)

    val myClass = ClassWithConstants()
    myClass.printConstants()
}