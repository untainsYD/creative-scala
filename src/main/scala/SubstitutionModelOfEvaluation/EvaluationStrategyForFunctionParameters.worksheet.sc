// Call-by-value
def callByValue(x: Int): Unit = {
    println("x1 = " + x)
    println("x2 = " + x)
}

// Call-by-name
def callByName(x: => Int): Unit = {
    println("x1 = " + x)
    println("x2 = " + x)
}

val y = 10

callByValue(y)
// Output: x1 = 10, x2 = 10

callByName(y)
// Output: x1 = 10, x2 = 10

// In Scala, the default evaluation strategy for function parameters is call-by-value. Here's what happens in each case:
//     Call-by-Value (callByValue function):
//         The value of y (which is 10) is computed before entering the function.
//         This value is then substituted for x within the function body.
//         As a result, both occurrences of x inside the function refer to the same computed value of 10.
//     Output:
// x1 = 10
// x2 = 10

// Call-by-Name (callByName function):
//     The => in the parameter x: => Int indicates call-by-name.
//     The expression x is not evaluated immediately; instead, it is evaluated each time it is used within the function.
//     In this case, the expression x is printed twice, and each time it is evaluated independently.
// Output:
//     x1 = 10
//     x2 = 10

// In both cases, the final output is the same. However, the key difference is in when the expression is evaluated. Call-by-value evaluates the expression once before entering the function, while call-by-name evaluates the expression each time it is referenced within the function.
