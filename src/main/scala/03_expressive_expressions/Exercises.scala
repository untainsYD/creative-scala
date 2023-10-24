import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global
import doodle.syntax.normalized

object Exercises extends App {
    Image.circle(40).fillColor(Color.red)
        .on(Image.circle(80).fillColor(Color.white))
        .on(Image.circle(120).fillColor(Color.red))
        .above(Image.rectangle(10, 50).fillColor(Color.brown))
        .above(Image.rectangle(50, 10).fillColor(Color.brown))
        .above(Image.rectangle(160, 50).fillColor(Color.green))
    .draw()
}
