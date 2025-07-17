import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

object ALineOfBoxes extends App {
    val aBox = Image.square(20).fillColor(Color.royalBlue)

    // Without recursion
    val oneBox = aBox
    val twoBoxes = aBox.beside(oneBox)
    val threeBoxes = aBox.beside(twoBoxes)
    // threeBoxes.draw()
    // The same substitution
    val threeBoxes2 = aBox.beside(aBox).beside(aBox)
    // threeBoxes2.draw()

    // With recursion
    def boxes(count: Int): Image = {
        // boxes(0) == Image.empty
        // boxes(1) == aBox.beside(boxes(0))
        // boxes(2) == aBox.beside(boxes(1))
        // boxes(3) == aBox.beside(boxes(2))

        count match {
            case 0 => Image.empty
            case n => aBox.beside(boxes(n - 1))
        }
    }
    boxes(5).draw();
}
