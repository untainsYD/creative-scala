// Now that we can write more complex expressions, we can talk a little more about types.
// One use of types is stopping us from calling methods that don't exist. The type of an expression tells the compiler what methods exist on the value it evaluates to. Our code won't compile if we try to call to a method that doesn't exist. Here are some simple examples.
// "Brontë" / "Austen"
// error:
// value / is not a member of String
// (2 + (1 / 0) + 3)
//        ^

// 1.take(2)
// error:
// value take is not a member of Int


// Types are a property of expressions and thus exist at compile time (as we have discussed before.) This means we can determine the type of an expression even if evaluating it results in an error at run time. For example, dividing an Int by zero causes a run-time error.
// 1 / 0
// java.lang.ArithmeticException: / by zero
// 	at repl.MdocSession$MdocApp.$init$$$anonfun$1(04-types.md:32)


// (2 + (1 / 0) + 3)        // type int
// (2 + (1 / 0) + 3):String // type string
