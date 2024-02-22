import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global
import doodle.image.Image.Elements.StrokeWidth

object ExerciseChessboard extends App:
    def chessboard(count: Int, color: Color): Image =
        count match
            case 0 =>
                val contrast = color.spin(180.degrees)
                val box = Image.square(20)
                box
                    .fillColor(color)
                    .beside(box.fillColor(contrast))
                    .above(box.fillColor(contrast).beside(box.fillColor(color)))
            case n =>
                chessboard(n - 1, color.spin(17.degrees))
                    .beside(chessboard(n - 1, color.spin(-7.degrees)))
                    .above(
                        chessboard(n - 1, color.spin(-19.degrees))
                            .beside(chessboard(n - 1, color.spin(3.degrees)))
                    )

    chessboard(5, Color.red).draw()

    // Image.square(20)
    //     .fillColor(Color.red)
    //     .beside(Image.square(20).fillColor(Color.red.spin(180.degrees)))
    //     .above(Image.square(20).fillColor(Color.red.spin(180.degrees)).beside(Image.square(20).fillColor(Color.red.spin(180.degrees))))
    //     .draw()
