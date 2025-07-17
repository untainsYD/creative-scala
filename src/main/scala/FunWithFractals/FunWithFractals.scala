import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

object FunWithFractals extends App {
    def chessboard(count: Int): Image = {
        val redSquare = Image.rectangle(50, 50).fillColor(Color.red)
        val blackSquare = Image.rectangle(50, 50).fillColor(Color.black)

        val baseCase = redSquare.beside(blackSquare).above(blackSquare.beside(redSquare))

        count match {
            case 0 => baseCase
            case n => {
                val unit = chessboard(n - 1)
                unit.beside(unit).above(unit.beside(unit))
                // (chessboard(n - 1).beside(chessboard(n - 1))).above(chessboard(n - 1).beside(chessboard(n - 1)))
            }
        }
    }
    // Draw the chessboard
    // chessboard(8).draw()

    def sierpinski(count: Int): Image = {
        val triangle = Image.equilateralTriangle(5).fillColor(Color.hotpink).noStroke
        val triforce = triangle.above(triangle.beside(triangle))

        count match {
            case 0 => triforce
            case n => {
                val unit = sierpinski(n - 1)
                // looks good to me!
                unit.above(unit.beside(unit))
            }
        }
    }
    // Draw Sierpinski triangle
    sierpinski(5).draw()
}
