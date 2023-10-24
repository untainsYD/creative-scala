import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

object Images extends App {
    // What is happening here? Image is an object and circle a method on that object. We pass to circle a parameter, 100 that gives the diameter of the circle we're constructing. Note the type of the result is Image.
    // Image.circle(100) // res0: Image = Circle(d = 100.0)

    // Image.circle(100).draw()

    // Doodle supports a handful of "primitive" images: circles, rectangles, and triangles. Let's try drawing a rectangle.
    // Image.rectangle(100, 50).draw()
    // Image.triangle(120, 80).draw()

    // Exercise: I Go Round in Circles
    // Image.circle(1).draw()
    // Image.circle(10).draw()
    // Image.circle(100).draw()


    // Exercise: My Type of Art
    // What is the type of a circle? A rectangle? A triangle?

    // They all have type Image, as we can tell from the worksheet.
    Image.circle(10) // doodle.core.Image
    Image.rectangle(10, 10) // doodle.core.Image
    Image.triangle(10, 10).draw() // draw method has Unit.Unit type
}
