import scala.concurrent.Future
import concurrent.ExecutionContext.Implicits.global

object SideEffects extends App {
    def computeA(): Int = { println("Open up a package of my Bologna"); 1 }
    def computeB(): Int = { println("Oh, i think the toast is done"); 2 }

    val fa = Future(computeA())
    val fb = Future(computeB())

    for {
        a <- fa
        b <- fb
    } yield a + b

    // Probably prints:
    // Open up a package of my Bologna
    // Oh, i think the toast is done

    // or prints:
    // Oh, i think the toast is done
    // Open up a package of my Bologna

    // But this code
    for {
        a <- Future(computeA())
        b <- Future(computeB())
    } yield a + b

    // Will print:
    // Open up a package of my Bologna
    // Oh, i think the toast is done
}
