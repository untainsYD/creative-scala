for (i <- 1 to 5) {
    println(i)
}

for i <- 1 to 5 do println(i) // Scala 3 syntax

val list = List(1, 2, 3, 4, 5)
list.foreach { element =>
    println(element)
}

var i = 0
while (i < 5) {
    println(i)
    i += 1
}

// do {...} while (...) syntax is no longer supported, see https://dotty.epfl.ch/docs/reference/dropped-features/do-while.html
// do {
//     println(i)
//     i += 1
// } while (i < 5)
var x = 0
while {
    x < 5
} do {
    println(x)
    x += 1
}
