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

fun main() {
    testAnnotations()
}