package example.myapp

data class Fish (var name: String)

fun fishExamples() {
    val fish = Fish("splashy")

    with (fish.name) {
        this.capitalize()
        println("Kotlin's with: ${ this.capitalize() }")

    }

    myWith (fish.name) {
        println("My with: ${ this.capitalize() }")
    }

    val fish2 = Fish(name="splashy").apply {
        name = "sharky"
    }

    println("Results of apply: ${ fish2.name }")

    val fish3 = Fish(name="flipper")

    fish3.run {
        name = "tuna"
    }

    println("Results of run: ${ fish3.name }")

    /* let is used for chaining */
    println(
        fish.let { it.name.capitalize()}
        .let{it + "fish"}
        .let{it.length}
        .let{it + 31}
    )

    println("Fish after let: ${fish.name}")
}

/* my implementation of the built-in with higher order function */
fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}


/*
    this can cause a lot of overhead on the runtime if used everywhere, another option is to use an inline function
    and let the comile time take the hit
*/
inline fun myInlineWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun runExample() {
    /* instantiate an interface for Runnable */
    val runnable = object : Runnable {
        override fun run() {
            println("I'm a Runnable")
        }
    }
    JavaRun.runNow(runnable)


    /* less verbose example using a lambda with last param syntax */
    JavaRun.runNow {
        println("Passing a lambda as a Runnable")
    }
}

fun main() {
//    fishExamples()
    runExample()
}

