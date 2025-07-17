import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

object Layout extends App {
    // (Image.circle(100).beside(Image.rectangle(100, 200))).draw()

    // (Image.circle(100).beside(Image.circle(50))).draw()

    // Image.circle(100).above(Image.circle(50)).draw()

    // Image.circle(100).on(Image.circle(50)).draw()

    // Exercises
    // Exercise: The Width of a Circle
    // Create the picture below using the layout methods and basic images we've covered so far.
    Image.circle(150).on(
        Image.circle(50)
            .beside(Image.circle(50))
            .beside(Image.circle(50))
    ).draw()
}
