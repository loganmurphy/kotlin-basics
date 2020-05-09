import java.util.*

val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun fishFood(day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" ->  "granules"
        "Friday" ->  "mosquitos"
        "Sunday" ->  "plankton"
        else -> "nothing!"
    }
}

fun swim (speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when  {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun randomDay() : String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun main() {
    val eager = decorations.filter {it[0] == 'p'}
    println("eager: $eager")

    val filtered = decorations.asSequence().filter {it[0] == 'p'}
    println("filtered: $filtered")

    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    val newLazyMap = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }

//    println("lazy: $lazyMap")
//    println("------")
//    println("first: ${lazyMap.first()}")
//    println("------")
//    println("lazy: ${lazyMap.last()}")
//    println("------")
//    println("all: ${lazyMap.toList()}")
    println("------")
    println("filtered: ${newLazyMap.toList()}")
}

