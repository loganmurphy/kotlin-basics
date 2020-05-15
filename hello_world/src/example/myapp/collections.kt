package example.myapp

fun main() {

    /* collections can have an explicit type like in C#, or it can be inferred */
    val listOfStrings = listOf<String>("1", "2", "3", "4", "5")
    println(listOfStrings)
    println(listOfStrings.sumBy { it.length})

    /* example with inferred typing */
    val lsitOfNums = listOf(1, 2, 3, 4, 5)

    println(lsitOfNums)
    println(lsitOfNums.sum())


    for (s in listOfStrings.listIterator()) {
        println("$s ")
    }

    val cures = hashMapOf<String, String>("white spots" to "Ich", "red sores" to "hole disease")
    println(cures.get("white spots"))
    cures.put("no gills", "death")
    cures.map() {(key, value) -> println("$key: $value") }
    println(cures["red sores"])
    println(cures["scale loss"])
    println(cures.getOrDefault("nothing here", "something about fish"))
    println(cures.getOrElse("nothing here either") { 1 })

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    println(inventory.toString())
    inventory.remove("fish net")
    println(inventory.toString())
}