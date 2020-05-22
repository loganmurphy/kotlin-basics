package example.myapp.annotations
import kotlin.reflect.full.*

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImAPlant class Plant {
    @get:OnGet
    val isGrowing: Boolean = true

    @set: OnSet
    var needsFood: Boolean = false
}

fun testAnnotations() {
    val plantObj = Plant::class
    val myAnnotationObj = plantObj.findAnnotation<ImAPlant>()
    println(myAnnotationObj)
}

fun labels() {
    outerLoop@ for (i in 1..100) {
        print("$i")
        for (j in 1..100) {
            if(i > 10) break@outerLoop //break to outer loop
        }
    }
}

fun main() {
//    testAnnotations()
    labels()
}