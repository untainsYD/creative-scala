// Types describe a set of values. The expression 1 + 2 has the type Int. We can see this in the worksheet, which shows the type of the expression (Int) and value the expression evaluates to (3).
1 + 2
// res0: Int = 3

// A type of Int means if the expression is successfully evaluated, then the value will be one of the approximately 4.2 billion values the computer understands to be integers. (Integers are also known as "whole numbers".)

// We determine the type of an expression without running it. This means that types are a property of expressions. We can give a type to an expression even if, when we evaluate it, the computation fails. This is also why the type doesn't tell us the specific value the expression evaluates to: we'd have to evaluate the expression to know that.

// Types are worked out in a process known as a type-checking, which is part of compilation. Before a Scala program is run, it must be compiled. Compilation checks that a program makes sense. It must be syntactically correct, meaning it must be written according to the rules of Scala. For example (1 + 2) is syntactically correct, but (1 + 2 is not because there is no ) to match the (. It must also type check, meaning the types must be correct for the operations we're trying to do. 1 + 2 type checks (we are adding integers), but 1.toUpperCase does not (there is no concept of upper and lower case for integers.)
