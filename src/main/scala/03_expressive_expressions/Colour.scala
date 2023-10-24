import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

object Colour extends App {
    // Image.circle(100).fillColor(Color.hotpink).draw()

    // Image.circle(100).strokeColor(Color.chartreuse).draw()

    // Image.circle(100).strokeWidth(3).draw()

    // Image.circle(100).noFill.draw()

    // Image.circle(100).noStroke.draw()

    // Image
    //     .circle(100)
    //     .fillColor(Color.wheat)
    //     .strokeColor(Color.midnightBlue)
    //     .strokeWidth(7)
    //     .draw()

    // Exercises
    // Exercise: Evil Eye
    // Make the image in Figure pictures:evil-eye, designed to look like a traditional amulet protecting against the evil eye. I used cornflowerBlue for the iris, and darkBlue for the outer color, but experiment with your own choices!

    Image.circle(40).fillColor(Color.indianRed).noStroke
        .on(Image.circle(80).fillColor(Color.mistyRose).strokeColor(Color.darkRed).strokeWidth(2.5)
            .on(Image.circle(120).fillColor(Color.whiteSmoke).noStroke
                .on(Image.circle(200).fillColor(Color.darkRed).noStroke))
        ).draw()
}
