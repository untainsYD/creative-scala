import doodle.core.*
import doodle.image.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.java2d.*
import cats.effect.unsafe.implicits.global

// Substitution:
//     Substitution refers to the process of replacing the variables in an expression with their corresponding values.
//     In Scala, substitution is typically used in the evaluation of expressions, where the actual values of variables are substituted into the expression.

// Order of Evaluation:
//     The order of evaluation determines the sequence in which subexpressions within a larger expression are evaluated.
//     Scala follows call-by-value evaluation strategy by default, which means that arguments to functions are evaluated before the function is called.
//     However, Scala also supports call-by-name evaluation through the use of a => syntax in function parameters. In call-by-name, the argument is not evaluated until it is actually used in the function body.

object OrderOfEvaluation extends App {
    // println("Moonage daydream".indexOf("N"));

    // val c = "N"
    // val b = "Moonage daydream"
    // val a = 1
    // val d = b.indexOf(c)
    // val e = a + d
    // println(e);

    // val e = a + d
    // val a = 2
    // val b = "Moonage daydream"
    // val c = "N"
    // val d = b.indexOf(c)
    // print(e, d);


    // println("Happy birthday to you!")
    // println("Happy birthday to you!")
    // println("Happy birthday to you!")

    // val happy = println("Happy birthday to you!")
    // happy
    // happy
    // happy


    // {
    //     val one = 1
    //     val two = 2
    //     one + two
    //     print(one + two)
    // }


    // Color.hsl(
    //     {
    //         println("a")
    //         0.degrees
    //     },
    //     {
    //         println("b")
    //         1.0
    //     },
    //     {
    //         println("c")
    //         1.0
    //     }
    // )

    // Color.hsl({ println("a"); 0.degrees },
    //           { println("b"); 1.0 },
    //           { println("c"); 1.0 })


    // val b = {
    //     println("Side effect")

    //     2 + 2
    // }
    // val resultImpure = b + b

    // println("Impure result:" + " " + resultImpure)

    // val twoHundred = {
    //     println("test 2")
    //     200
    // }
    // println(twoHundred)
    // println(twoHundred)
    // println(twoHundred)
    // val hundred = {
    //     println("test 1")

    //     100
    // }

    // val myRect = Image.rectangle(hundred, twoHundred)

    // { println("a"); 1 } + { println("b"); 2 } + { println("c"); 3 }
    // val order = { println("a"); 1 } + { println("b"); 2 } + { println("c"); 3 };
    // print(order);

    var total = 0;
    def addAndPrint(x: Int): Unit = {
        total += x;  // Modifying external state (side effect)
        println("Total: " + total);
    }

    addAndPrint(5);
    addAndPrint(10);
}
