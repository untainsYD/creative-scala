val testTupleSize = ("test", 25, 3.15, 'a', true)

println(testTupleSize(0))
println(testTupleSize(1))
println(testTupleSize(2))
println(testTupleSize(3))
println(testTupleSize(4))

val tupleListEval = List(("One", 1), ("Two", 2), ("Three", 3), ("Four", 4), ("Five", 5))
for (a, b) <- tupleListEval do
    println(a + " " + b)

val numPairs = List((2, 5), (3, -7), (20, 56))
for (a, b) <- numPairs do
    println(a * b)
