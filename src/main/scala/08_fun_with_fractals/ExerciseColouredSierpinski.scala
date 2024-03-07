import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global
import doodle.image.Image.Elements.StrokeWidth

object exerciseColouredSierpinski extends App {
    def changeColourSierpinski(count: Int, colourSpin: Int): Image = {
        val triangle = Image.equilateralTriangle(30).fillColor(Color.hotpink.spin(colourSpin.degrees)).noStroke

        def isPrime(n: Int): Boolean = !((2 until n - 1) exists (n % _ == 0))

        def loop(count: Int, colourSpin: Int): Image = {
            val primeNumbers = Stream.from(2).filter(isPrime)
            val spins = primeNumbers.take(count).map(_ * 10 + colourSpin).toList
            spins.foldLeft(triangle) { (acc, spin) =>
                acc.above(acc.beside(acc).fillColor(Color.hotpink.spin(spin.degrees)).noStroke)
            }
        }

        loop(count, colourSpin)
    }

    changeColourSierpinski(3, 5).draw()
}
