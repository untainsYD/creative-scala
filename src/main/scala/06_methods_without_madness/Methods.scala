import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

object Methods extends App {
    def boxes(color: Color): Image = {
        val box =
            Image.rectangle(40, 40).
                strokeWidth(5.0).
                strokeColor(color.spin(30.degrees)).
                fillColor(color)

        box.beside(box).beside(box).beside(box).beside(box)
    }

    boxes(Color.bisque).draw();
    boxes(Color.paleGoldenrod).draw();
    boxes(Color.mistyRose).draw();
}
